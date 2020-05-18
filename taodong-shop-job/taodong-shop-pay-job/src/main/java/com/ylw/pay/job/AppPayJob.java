package com.ylw.pay.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description: 支付服务任务调度
 * create by: YangLinWei
 * create time: 2020/5/18 4:38 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class AppPayJob {

	public static void main(String[] args) {
		SpringApplication.run(AppPayJob.class, args);
	}

}
