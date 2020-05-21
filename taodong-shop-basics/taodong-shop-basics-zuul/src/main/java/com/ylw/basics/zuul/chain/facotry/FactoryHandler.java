package com.ylw.basics.zuul.chain.facotry;

import com.ylw.basics.zuul.chain.handler.GatewayHandler;
import com.ylw.common.web.core.util.SpringContextUtil;

public class FactoryHandler {

    public static GatewayHandler getHandler() {
        // 1.黑名单拦截
        GatewayHandler handler1 = (GatewayHandler) SpringContextUtil.getBean("blackListHandler");

        // 2.API接口参数接口验签
        GatewayHandler handler2 = (GatewayHandler) SpringContextUtil.getBean("verifySignHandler");
        handler1.setNextHandler(handler2);

        // 3.参数过滤
        GatewayHandler handler3 = (GatewayHandler) SpringContextUtil.getBean("filterParamHandler");
        handler1.setNextHandler(handler3);

        //4.验证accessToken
        GatewayHandler handler4 = (GatewayHandler) SpringContextUtil.getBean("apiAuthorityHandler");
        handler3.setNextHandler(handler4);

        return handler1;
    }
}
