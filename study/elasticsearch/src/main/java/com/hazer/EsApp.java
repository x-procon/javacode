package com.hazer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-20 17:58
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class EsApp {
    public static void main(String[] args) {
        SpringApplication.run(EsApp.class,args);
    }
}
