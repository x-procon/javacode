package com.hazer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 *
 * @author Hazer
 * @date 2020-07-20 17:58
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StudyApp {
    public static void main(String[] args) {
        SpringApplication.run(StudyApp.class, args);
    }
}
