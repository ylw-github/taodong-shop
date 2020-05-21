package com.ylw.basics.zuul.chain.handler.impl;

import com.netflix.zuul.context.RequestContext;
import com.ylw.basics.zuul.chain.handler.GatewayHandler;
import com.ylw.basics.zuul.chain.handler.impl.base.BaseHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * description: 参数转义handler
 * create by: YangLinWei
 * create time: 2020/5/21 3:37 下午
 */
@Component
@Slf4j
public class FilterParamHandler extends BaseHandler implements GatewayHandler {
    @Override
    public Boolean service(RequestContext ctx, String ipAddres, HttpServletRequest request, HttpServletResponse response) {
        Map<String, List<String>> requestQueryParams = ctx.getRequestQueryParams();
        if (requestQueryParams == null) {
            requestQueryParams = new HashMap<>();
        }
        Enumeration em = request.getParameterNames();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getParameter(name);
            ArrayList<String> arrayList = new ArrayList<>();
            // 将参数转化为html参数 防止xss攻击 < 转为&lt;
            arrayList.add(StringEscapeUtils.escapeHtml(value));
            requestQueryParams.put(name, arrayList);
            log.info(">>>>>>过滤参数name:{},arrayList:{}>>>>>>>", name, arrayList);
        }
        if (requestQueryParams != null && requestQueryParams.size() > 0) {
            ctx.setRequestQueryParams(requestQueryParams);
        }
        if (gatewayHandler != null) {
            gatewayHandler.service(ctx, ipAddres, request, response);
        }
        return Boolean.TRUE;
    }
}
