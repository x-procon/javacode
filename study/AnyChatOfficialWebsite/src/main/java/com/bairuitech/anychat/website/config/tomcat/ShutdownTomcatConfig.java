package com.bairuitech.anychat.website.config.tomcat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author hazer
 */
@Component
public class ShutdownTomcatConfig {

    private final GracefulShutdownTomcat gracefulShutdownTomcat;

    @Autowired
    public ShutdownTomcatConfig(GracefulShutdownTomcat gracefulShutdownTomcat) {
        this.gracefulShutdownTomcat = gracefulShutdownTomcat;
    }

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers(gracefulShutdownTomcat);
        return tomcat;
    }
}
