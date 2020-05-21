package com.ylw.basics.zuul.chain.handler;

import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: 网关Handler接口
 * create by: YangLinWei
 * create time: 2020/5/21 3:33 下午
 */
public interface GatewayHandler {
    /**
     * 网关拦截处理请求
     */
    Boolean service(RequestContext ctx, String ipAddres, HttpServletRequest request, HttpServletResponse response);

    /**
     * 设置下一个
     */
    void setNextHandler(GatewayHandler gatewayHandler);

    /**
     * 获取下一个Handler
     *
     * @return
     */
    public GatewayHandler getNextHandler();
}