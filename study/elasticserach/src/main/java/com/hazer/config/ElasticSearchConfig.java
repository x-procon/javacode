package com.hazer.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-19 10:10
 */
@Configuration
public class ElasticSearchConfig {

    @Bean
    public RestHighLevelClient client(){
        HttpHost httpHost = new HttpHost("192.168.1.77", 9200,"http");
        return new RestHighLevelClient(RestClient.builder(httpHost));
    }
}
