package cc.procon.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * @author procon
 */
@Configuration
@Slf4j
public class ElasticSearchConfig {
    private final EsProperties esProperties;

    public ElasticSearchConfig(@Autowired EsProperties esProperties) {
        this.esProperties = esProperties;
    }

    @Bean("restHighLevelClient")
    @SuppressWarnings("deprecation")
    public RestHighLevelClient client() {
        log.info("初始化RestHighLevelClient..."+esProperties.toString());
        ArrayList<HttpHost> hostList = new ArrayList<>();
        String[] hostStrs =esProperties.getClusterNodes().split(",");

        for (String host : hostStrs) {
            String[] hostPort = host.split(":");
            hostList.add(new HttpHost(hostPort[0], Integer.parseInt(hostPort[1]), esProperties.getScheme()));
        }
        RestClientBuilder builder = RestClient.builder(hostList.toArray(new HttpHost[0]));

        // 异步httpclient连接延时配置
        builder.setRequestConfigCallback(requestConfigBuilder -> {
            requestConfigBuilder.setConnectTimeout(esProperties.getConnectTimeOut());
            requestConfigBuilder.setSocketTimeout(esProperties.getSocketTimeOut());
            requestConfigBuilder.setConnectionRequestTimeout(esProperties.getConnectionRequestTimeOut());
            return requestConfigBuilder;
        });

        // 异步httpclient连接数配置
        builder.setHttpClientConfigCallback(httpClientBuilder -> {
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(
                    AuthScope.ANY, new UsernamePasswordCredentials(esProperties.getUsername(), esProperties.getPassword()));
            httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
            httpClientBuilder.setMaxConnTotal(esProperties.getMaxConnectNum());
            httpClientBuilder.setMaxConnPerRoute(esProperties.getMaxConnectPerRoute());
            return httpClientBuilder;
        });

        return new RestHighLevelClient(builder);
    }
}
