package com.ylw.service.weixin.impl;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.core.api.BaseApiService;
import com.ylw.common.core.constants.Constants;
import com.ylw.service.api.weixin.VerificaCodeService;
import com.ylw.common.core.entity.BaseResponse;
import com.ylw.common.core.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificaCodeServiceImpl extends BaseApiService<JSONObject> implements VerificaCodeService {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public BaseResponse<JSONObject> verificaWeixinCode(String phone, String weixinCode) {
        if (StringUtils.isEmpty(phone)) {
            return setResultError("手机号码不能为空!");
        }
        if (StringUtils.isEmpty(weixinCode)) {
            return setResultError("注册码不能为空!");
        }
        String code = redisUtil.getString(Constants.WEIXINCODE_KEY + phone);
        if (StringUtils.isEmpty(code)) {
            return setResultError("注册码已经过期,请重新发送验证码");
        }
        if (!code.equals(weixinCode)) {
            return setResultError("注册码不正确");
        }

        return setResultSuccess("注册码验证码正确");
    }

}
