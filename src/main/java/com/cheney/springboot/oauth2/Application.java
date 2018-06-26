package com.cheney.springboot.oauth2;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


@MapperScan("com.cheney.springboot.oauth2.dao")
@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableAuthorizationServer
public class Application {

    public static void main(String[] args){
        new SpringApplication(Application.class).run(args);
    }

}
