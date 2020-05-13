package com.ylw.service.pay;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * description: 支付服务
 * create by: YangLinWei
 * create time: 2020/5/13 11:38 上午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2Doc
@MapperScan(basePackages = "com.ylw.service.pay.mapper")
@ComponentScan(basePackages = "com.ylw")
public class AppPay {

	public static void main(String[] args) {
		SpringApplication.run(AppPay.class, args);
	}
}
