package com.hazer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName Curstomer80_Fegin_App
 * @Description TODO
 * @Author Hazer
 * @Date 2020/1/31 10:50
 **/
@SpringBootApplication
@EnableFeignClients(basePackages= {"com.hazer.springcloud"})
public class Curstomer80_Fegin_App {
    public static void main(String[] args) {
        SpringApplication.run(Curstomer80_Fegin_App.class,args);
    }
}
