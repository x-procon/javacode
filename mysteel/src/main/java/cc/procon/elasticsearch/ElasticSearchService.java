package cc.procon.elasticsearch;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 刘春发
 * @version 1.0.0
 * @ClassName EsService.java
 * @Description es服务类
 * @createTime 2022年04月13日 14:03
 */
@Slf4j
@Service
public class ElasticSearchService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    private BulkProcessor bulkProcessor;
    @Autowired
    private EsProperties esProperties;

    private int count;
    private long time;


    public boolean hasEsRecord(String indexName, String column, Object columnValue, Map<String, Object> jsonMap) throws IOException {
        SearchRequest search = new SearchRequest(indexName);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.matchQuery(column, columnValue));
        sourceBuilder.query(boolQueryBuilder);
        sourceBuilder.from(0);
        sourceBuilder.size(1);
        search.source(sourceBuilder);
        SearchResponse resp = restHighLevelClient.search(search, RequestOptions.DEFAULT);
        if(RestStatus.OK.equals(resp.status())){
            long totalHits = resp.getHits().getTotalHits().value;
            if(totalHits!=1){
                log.info("查询维表补偿返回不符合修改，totalHists"+totalHits+"查询条件"+sourceBuilder.toString());
                return false;
            }else{
                SearchHit[] hits = resp.getHits().getHits();
                for (SearchHit hit : hits) {
                    UpdateRequest request = new UpdateRequest(indexName, null, hit.getId());
                    ObjectMapper mapper = new ObjectMapper();
                    byte[] json = mapper.writeValueAsBytes(jsonMap);
                    request.doc(json, XContentType.JSON);
                    this.update(request);
                }
                return true;
            }
        }else{
            log.error("查询维表补偿返回多条数据异常"+resp);
            //查询返回失败，返回true，避免重复数据
            return true;
        }
    }

    public GetResponse getIndexById(GetRequest getRequest) throws IOException {
        GetResponse getResp = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        return getResp;
    }



    private BulkProcessor.Listener getListener() {
        return new BulkProcessor.Listener() {
            //beforeBulk会在批量提交之前执行
            @Override
            public void beforeBulk(long executionId, BulkRequest bulkRequest) {
                int numberOfActions = bulkRequest.numberOfActions();
                count += numberOfActions;
                log.debug("开始执行第 [{}] 次 批量提交，本次提交个数 {} 个，总计提交个数 {} 个", executionId, numberOfActions, count);
            }

            //第一个afterBulk会在批量成功后执行，可以跟beforeBulk配合计算批量所需时间
            @Override
            public void afterBulk(long executionId, BulkRequest bulkRequest, BulkResponse response) {
                if (response.hasFailures()) {
                    log.info("[ERROR]:Bulk [{}] executed with failures,response = {}", executionId,
                            response.buildFailureMessage());
                } else {
                    time += response.getTook().getMillis();
                    log.debug("执行第 [{}] 次 批量提交，总计花费时间 {} 秒", executionId, time / 1000);
                }
            }

            //第二个afterBulk会在批量失败后执行
            @Override
            public void afterBulk(long executionId, BulkRequest bulkRequest, Throwable throwable) {
                log.error("---尝试操作" + bulkRequest.numberOfActions() + "条数据失败---", throwable);
            }
        };
    }

    @PostConstruct
    public void init() {
        BulkProcessor.Listener listener = getListener();

        BulkProcessor processor = BulkProcessor
                .builder((request, bulkListener) -> restHighLevelClient.bulkAsync(request, RequestOptions.DEFAULT,
                        bulkListener), listener)
                // 1000条数据请求执行一次bulk
                .setBulkActions(10000)
                // 5mb的数据刷新一次bulk
                .setBulkSize(new ByteSizeValue(5L, ByteSizeUnit.MB))
                // 并发请求数量, 0不并发, 1并发允许执行
                .setConcurrentRequests(1)
                // 固定5s必须刷新一次
                .setFlushInterval(TimeValue.timeValueSeconds(5))
                // 重试5次，间隔1s
                .setBackoffPolicy(BackoffPolicy.constantBackoff(TimeValue.timeValueSeconds(1L), 3))
                .build();
        this.bulkProcessor = processor;
    }

    /**
     * 修改
     *
     * @param request 请求参数
     */
    public void update(UpdateRequest request) {
        this.bulkProcessor.add(request);
    }

    public IndexResponse highClientSave(IndexRequest request) throws IOException {
        return this.restHighLevelClient.index(request, RequestOptions.DEFAULT);
    }

    /**
     * 新增
     *
     * @param request 请求参数
     */
    public void insert(IndexRequest request) {
        this.bulkProcessor.add(request);
    }

    /**
     * 删除
     *
     * @param request 请求参数
     */
    public void delete(DeleteRequest request) {
        this.bulkProcessor.add(request);
    }

    @PreDestroy
    public void destroy() {
        try {
            bulkProcessor.awaitClose(30, TimeUnit.SECONDS);
            this.clearCounter();
        } catch (InterruptedException e) {
            log.error("Failed to close bulkProcessor...", e);
            Thread.currentThread().interrupt();
        }
        log.info("bulkProcessor closed!");
    }

    private void clearCounter() {
        this.count = 0;
        this.time = 0;
    }

    public void updateEsData(String indexName, Object data, SearchHit searchHit) {

        UpdateRequest request = new UpdateRequest(indexName, null, searchHit.getId());

        ObjectMapper mapper = new ObjectMapper();

        byte[] json;

        try {

            json = mapper.writeValueAsBytes(data);

            request.doc(json, XContentType.JSON);

            this.update(request);

        } catch (JsonProcessingException e) {

            log.error(e.getMessage(), "");
        }
    }
}
