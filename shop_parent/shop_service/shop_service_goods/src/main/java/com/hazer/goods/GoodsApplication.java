package com.hazer.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 开启客户端
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.hazer.goods.dao"})  //开启通用Mapper包扫描
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
