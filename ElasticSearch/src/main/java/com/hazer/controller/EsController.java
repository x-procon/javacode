package com.hazer.controller;

import com.alibaba.fastjson.JSON;
import com.hazer.entity.Content;
import com.hazer.entity.ResultModel;
import com.hazer.jsoup.JsoupUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-20 17:20
 */
@RestController
public class EsController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @RequestMapping(value = "add/{keyword}")
    public ResultModel addData(@PathVariable(value = "keyword") String keyword) {
        try {
            List<Content> contents = JsoupUtil.parseJD(keyword);
            BulkRequest bulkRequest = new BulkRequest();
            bulkRequest.timeout(TimeValue.timeValueSeconds(600));
            for (int i = 0; i < contents.size(); i++) {
                IndexRequest indexRequest = new IndexRequest("hazer-es");
                bulkRequest.add(indexRequest.source(JSON.toJSONString(contents.get(i)), XContentType.JSON));
            }
            BulkResponse response = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            return ResultModel.success(!response.hasFailures());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultModel.fail();
    }

    @GetMapping(value = "page/{keyword}/{pageNo}/{pageSize}")
    public ResultModel searchPage(@PathVariable("keyword") String keyword,
                                  @PathVariable("pageNo") Integer pageNo,
                                  @PathVariable("pageSize") Integer pageSize) throws IOException {
        if (pageNo < 0) {
            return ResultModel.fail("参数错误", null);
        }
        //条件搜索
        SearchRequest request = new SearchRequest("hazer-es");
        SearchSourceBuilder searchBuilder = new SearchSourceBuilder();
        //分页
        searchBuilder.from(pageNo);
        searchBuilder.size(pageSize);
        //精确匹配
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("name", keyword);
        searchBuilder.query(queryBuilder);
        searchBuilder.timeout(TimeValue.timeValueMinutes(3));
        //执行搜索
        request.source(searchBuilder);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        //解析结果
        SearchHit[] hits = response.getHits().getHits();
        List<Map<String, Object>> maps = new ArrayList<>();
        for (SearchHit documentFields : hits) {
            maps.add(documentFields.getSourceAsMap());
        }
        return ResultModel.success("获取成功", maps);
    }
}


