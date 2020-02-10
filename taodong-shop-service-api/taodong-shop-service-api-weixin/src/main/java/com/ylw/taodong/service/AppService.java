package com.ylw.taodong.service;

import com.ylw.taodong.entity.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "微信服务接口")
public interface AppService {

    @ApiOperation(value = "微信应用服务接口")
    @GetMapping("/getApp")
    public AppEntity getApp();

}
