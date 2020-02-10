package com.ylw.taodong.service;

import com.ylw.taodong.entity.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "会员服务接口")
public interface MemberService {

    @ApiOperation(value = "会员服务调用微信服务")
    @GetMapping("/memberInvokWeixin")
    public AppEntity memberInvokWeixin();

}
