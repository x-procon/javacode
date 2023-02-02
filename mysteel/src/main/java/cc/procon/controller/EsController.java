package cc.procon.controller;

import cc.procon.mapper.ods.EsMapper;
import cc.procon.mapper.ods.PvnFundRiskStatsMapper;
import cc.procon.model.po.PvnFundRiskStats;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * es
 *
 * @author procon
 * @since 2023-01-29
 */
@Slf4j
@RestController
@RequestMapping("/es")
public class EsController {
     public static final int PAGE_SIZE = 10000;
    @Autowired
    private EsMapper esMapper;

    @Autowired
    private PvnFundRiskStatsMapper pvnFundRiskStatsMapper;

    @Autowired
    private RestHighLevelClient client;
    @RequestMapping(value = "/dataSync")
    public void dataSync() throws Exception{
        int count = pvnFundRiskStatsMapper.count();
        String index = "pvn_fund_risk_stats";
        //总页数
        int totalPage = (count + PAGE_SIZE - 1) / PAGE_SIZE;
        for (int i = 0; i < totalPage; i++) {
            log.info("共:{}条记录,共:{}页，当前第{}页", count, totalPage, i + 1);
            int startRow = i * PAGE_SIZE;
            int endRow = (i + 1) * PAGE_SIZE;
            List<PvnFundRiskStats> pvnNavList = pvnFundRiskStatsMapper.pageQuery(startRow, endRow);
            // 转JSON
            //去es查询是否存在
            ObjectMapper mapper = new ObjectMapper();
            // 2、构造一个执行批量操作的对象,将准备好的数据封装进去
            BulkRequest request = new BulkRequest();
            for (PvnFundRiskStats pvnNav : pvnNavList) {
                String s = mapper.writeValueAsString(pvnNav);
                request.add(new IndexRequest(index).id(pvnNav.getId().toString()).source(s, XContentType.JSON));
            }
            // 3、发送批量添加的请求
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);

            // 4、查看结果
            System.out.println(bulkResponse.status());


        }

    }


}
