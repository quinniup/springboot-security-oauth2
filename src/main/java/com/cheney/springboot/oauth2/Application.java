package com.cheney.springboot.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;


@MapperScan("com.cheney.springboot.oauth2.dao")
@org.springframework.boot.autoconfigure.SpringBootApplication
public class Application {

    public static void main(String[] args){
        new SpringApplication(Application.class).run(args);
    }
}
