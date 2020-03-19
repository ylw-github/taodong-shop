package com.xxl.sso.server.controller.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * description: web mvc config
 * create by: YangLinWei
 * create time: 2020/3/19 9:17 上午
 */
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}