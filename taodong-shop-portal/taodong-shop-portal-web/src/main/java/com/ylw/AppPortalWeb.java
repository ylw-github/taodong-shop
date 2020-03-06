package com.ylw;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
public class AppPortalWeb {

	public static void main(String[] args) {
		SpringApplication.run(AppPortalWeb.class, args);
	}
}
