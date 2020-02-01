package com.ylw.taodong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppWeiXin {

    public static void main(String[] args) {
        SpringApplication.run(AppWeiXin.class, args);
    }

}