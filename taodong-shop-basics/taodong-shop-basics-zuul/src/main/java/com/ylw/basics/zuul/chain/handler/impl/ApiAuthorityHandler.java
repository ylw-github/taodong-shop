package com.ylw.basics.zuul.chain.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.context.RequestContext;
import com.ylw.basics.zuul.chain.handler.GatewayHandler;
import com.ylw.basics.zuul.chain.handler.impl.base.BaseHandler;
import com.ylw.basics.zuul.feign.AuthorizationServiceFeign;
import com.ylw.common.web.core.entity.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: 校验AccessToken Handler
 * create by: YangLinWei
 * create time: 2020/5/21 3:36 下午
 */
@Component
@Slf4j
public class ApiAuthorityHandler extends BaseHandler implements GatewayHandler {

    @Autowired
    private AuthorizationServiceFeign verificaCodeServiceFeign;

    @Override
    public Boolean service(RequestContext ctx, String ipAddres, HttpServletRequest request, HttpServletResponse response) {
        String servletPath = request.getServletPath();
        log.info(">>>>>servletPath:" + servletPath + ",servletPath.substring(0, 5):" + servletPath.substring(0, 5));
        if (!servletPath.substring(0, 7).equals("/public")) {
            return true;
        }
        String accessToken = request.getParameter("accessToken");
        log.info(">>>>>accessToken验证:" + accessToken);
        if (StringUtils.isEmpty(accessToken)) {
            resultError(ctx, "AccessToken cannot be empty");
            return false;
        }
        // 调用接口验证accessToken是否失效
        BaseResponse<JSONObject> appInfo = verificaCodeServiceFeign.getAppInfo(accessToken);
        log.info(">>>>>>data:" + appInfo.toString());
        if (!isSuccess(appInfo)) {
            resultError(ctx, appInfo.getMsg());
            return false;
        }
        if (gatewayHandler != null) {
            gatewayHandler.service(ctx, ipAddres, request, response);
        }
        return true;
    }

}
