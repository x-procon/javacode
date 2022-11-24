package cc.procon.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author 刘春发
 * @version 1.0.0
 * @ClassName RestTemplateConfig.java
 * @Description RestTemplate配置类
 * @createTime 2022年05月27日 09:50
 */
@Slf4j
@Configuration
public class RestTemplateConfig {
    @Bean
    public ClientHttpRequestFactory initHttpRequestFactory(){
        log.info("初始化ClientHttpRequestFactory...");
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //单位为ms
        factory.setReadTimeout(500000000);
        //单位为ms
        factory.setConnectTimeout(500000000);
        return factory;
    }
    @Bean
    public RestTemplate restTemplate(){
        log.info("初始化restTemplate...");
        ClientHttpRequestFactory factory = initHttpRequestFactory();
        return new RestTemplate(factory);
    }
}
