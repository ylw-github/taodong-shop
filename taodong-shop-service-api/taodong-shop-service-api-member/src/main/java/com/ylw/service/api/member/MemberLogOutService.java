package com.ylw.service.api.member;

import com.alibaba.fastjson.JSONObject;
import com.ylw.api.member.dto.intput.UserLoginInDTO;
import com.ylw.api.member.dto.output.UserOutDTO;
import com.ylw.common.web.core.entity.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * description: 用户登出接口
 * create by: YangLinWei
 * create time: 2020/3/11 9:59 上午
 */
@Api(tags = "用户登出服务接口")
public interface MemberLogOutService {
    /**
     * 用户登出接口
     *
     * @param token
     * @return
     */
    @DeleteMapping("/logout")
    @ApiOperation(value = "/logout")
    BaseResponse<JSONObject> logout(@RequestParam("token") String token);

}
