package com.hazer.gyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName DeptProvider8001_App
 * @Description TODO
 * @Author Hazer
 * @Date 2020/1/22 19:34
 **/
@SpringBootApplication
@EnableEurekaClient   //启动后注册到服务中心
public class DeptProvider8001_App {
    public static void main(String[] args)
    {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }

}
