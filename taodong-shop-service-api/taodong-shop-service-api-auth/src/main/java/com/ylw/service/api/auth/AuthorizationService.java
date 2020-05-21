package com.ylw.service.api.auth;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.web.core.entity.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description: 用户授权接口
 * create by: YangLinWei
 * create time: 2020/5/21 11:22 上午
 */
public interface AuthorizationService {
    /**
     * 机构申请 获取appid 和appsecret
     *
     * @return
     */
    @GetMapping("/applyAppInfo")
    public BaseResponse<JSONObject> applyAppInfo(@RequestParam("appName") String appName);

    /*
     * 使用appid 和appsecret密钥获取AccessToken
     */
    @GetMapping("/getAccessToken")
    public BaseResponse<JSONObject> getAccessToken(@RequestParam("appId") String appId,
                                                   @RequestParam("appSecret") String appSecret);

    /*
     * 验证Token是否失效
     */
    @GetMapping("/getAppInfo")
    public BaseResponse<JSONObject> getAppInfo(@RequestParam("accessToken") String accessToken);

}

