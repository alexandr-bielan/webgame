package com.web.server.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class WebserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebserverApplication.class, args);
    }

}
