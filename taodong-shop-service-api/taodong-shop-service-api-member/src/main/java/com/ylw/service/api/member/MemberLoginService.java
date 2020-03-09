package com.ylw.service.api.member;

import com.alibaba.fastjson.JSONObject;
import com.ylw.api.member.dto.intput.UserLoginInDTO;
import com.ylw.common.web.core.entity.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * description: 用户登录接口服务
 * create by: YangLinWei
 * create time: 2020/3/3 4:35 下午
 */
@Api(tags = "用户登录服务接口")
public interface MemberLoginService {
    /**
     * 用户登录接口
     *
     * @param userLoginInDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "会员用户登陆信息接口")
    BaseResponse<JSONObject> login(@RequestBody UserLoginInDTO userLoginInDTO);

}
