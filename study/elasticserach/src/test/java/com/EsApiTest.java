package com;

import com.hazer.config.ElasticSearchConfig;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-19 10:46
 */

@SpringBootTest(classes = ElasticSearchConfig.class)
public class EsApiTest {

   @Autowired
   private RestHighLevelClient client;

   @Test
   public void testEs() throws IOException {
      CreateIndexRequest request = new CreateIndexRequest("test11");
      CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
      System.out.println(createIndexResponse);
   }



}
