package com.hazer.gyo.hazer.springboot.config;

import com.hazer.gyo.hazer.springboot.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @ProjectName: javacode
 * @Package: gyo.hazer.springboot.config
 * @ClassName: MyWebConfig
 * @Author: Hazer
 * @Description:
 * @Date: 2019/12/24 22:05
 * @Version: 1.0
 */

@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    @Override

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("main");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInteInterceptor()).addPathPatterns("/**").
//                excludePathPatterns("/index.html","/user/login");
//    }

    @Bean
    public LocaleResolver myLocaleResolver() {
        return new MyLocalResolver();
    }
}
