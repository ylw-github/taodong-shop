package com.ylw.service.integral;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: 积分服务启动
 * create by: YangLinWei
 * create time: 2020/5/19 2:09 下午
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ylw.service.integral.mapper")
public class AppIntegral {

	public static void main(String[] args) {
		SpringApplication.run(AppIntegral.class, args);
	}

}
