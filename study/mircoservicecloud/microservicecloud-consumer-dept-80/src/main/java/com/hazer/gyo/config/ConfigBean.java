package com.hazer.gyo.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConfigBean
 * @Description TODO
 * @Author Hazer
 * @Date 2020/1/22 20:00
 **/
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public IRule myLBRule(){
//        return new RandomRule();
//    }
}
