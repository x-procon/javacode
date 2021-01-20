package com.hazer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName Eureka7003
 * @Description TODO
 * @Author Hazer
 * @Date 2020/1/30 10:52
 **/
@SpringBootApplication
@EnableEurekaServer
public class Eureka7003 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7003.class, args);
    }
}
