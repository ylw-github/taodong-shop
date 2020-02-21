package com.ylw.service.weixin.impl;

import com.ylw.service.api.weixin.AppService;
import com.ylw.api.weixin.entity.AppEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppServiceImpl implements AppService {

    @Value("${app.appsecret:defaultAppSecret}")
    private String appSecret;

    @GetMapping("/getApp")
    public AppEntity getApp() {
        return new AppEntity("1962264482", appSecret);
    }

}
