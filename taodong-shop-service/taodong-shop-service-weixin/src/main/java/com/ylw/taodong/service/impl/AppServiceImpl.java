package com.ylw.taodong.service.impl;

import com.ylw.taodong.entity.AppEntity;
import com.ylw.taodong.service.AppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppServiceImpl implements AppService {

    @GetMapping("/getApp")
    public AppEntity getApp() {
        return new AppEntity("1962264482", "ylw666");
    }

}
