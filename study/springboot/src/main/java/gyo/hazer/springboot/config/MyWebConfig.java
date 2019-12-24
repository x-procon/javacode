package gyo.hazer.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        registry.addViewController("/main.html").setViewName("dashboard");
    }
}
