package com.ylw.member.controller;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.web.core.base.BaseWebController;
import com.ylw.common.web.core.constants.WebConstants;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.common.web.core.util.CookieUtils;
import com.ylw.member.feign.MemberLogoutServiceFeign;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController extends BaseWebController {

    @Autowired
    private MemberLogoutServiceFeign memberLogoutServiceFeign;


    @DeleteMapping("/exit")
    @ResponseBody
    public BaseResponse<JSONObject> exit(HttpServletRequest request, HttpServletResponse response, Model model) {
        // 1.从cookie 中 获取 会员token
        String token = CookieUtils.getCookieValue(request, WebConstants.LOGIN_TOKEN_COOKIENAME, true);
        CookieUtils.deleteCookie(request, response, WebConstants.LOGIN_TOKEN_COOKIENAME);
        if (!StringUtils.isEmpty(token)) {
            // 2.调用登出服务接口
            return memberLogoutServiceFeign.logout(token);
        }
        return null;
    }
}
