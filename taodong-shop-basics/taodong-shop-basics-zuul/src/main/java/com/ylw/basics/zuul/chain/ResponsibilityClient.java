package com.ylw.basics.zuul.chain;

import com.netflix.zuul.context.RequestContext;
import com.ylw.basics.zuul.chain.facotry.FactoryHandler;
import com.ylw.basics.zuul.chain.handler.GatewayHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ResponsibilityClient {
    public void responsibility(RequestContext ctx, String ipAddres, HttpServletRequest request,
                               HttpServletResponse response) {
        GatewayHandler handler = FactoryHandler.getHandler();
        handler.service(ctx, ipAddres, request, response);
    }

}