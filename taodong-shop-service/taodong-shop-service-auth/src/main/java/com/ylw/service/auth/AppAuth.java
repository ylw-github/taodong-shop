package com.ylw.service.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * description: 认证启动
 * create by: YangLinWei
 * create time: 2020/5/21 11:24 上午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
// @EnableApolloConfig
@MapperScan(basePackages = "com.ylw.service.auth.mapper")
@ComponentScan(basePackages = "com.ylw")
public class AppAuth {

    public static void main(String[] args) {
        SpringApplication.run(AppAuth.class, args);
    }

}
