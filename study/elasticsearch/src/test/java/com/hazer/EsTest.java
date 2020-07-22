package com.hazer;

import com.hazer.elasticsearch.ElasticSearchConfig;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-20 17:02
 */
@SpringBootTest(classes = ElasticSearchConfig.class)
public class EsTest {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void test() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("haze-jd");
        CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        boolean acknowledged = response.isAcknowledged();
        System.out.println(acknowledged);
    }

}
