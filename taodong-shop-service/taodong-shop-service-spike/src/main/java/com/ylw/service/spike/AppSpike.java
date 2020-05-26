package com.ylw.service.spike;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.ylw.service.spike.mapper")
@ComponentScan(basePackages = "com.ylw")
@EnableHystrix
public class AppSpike {

	public static void main(String[] args) {
		SpringApplication.run(AppSpike.class, args);
	}

}
