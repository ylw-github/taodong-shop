package com.ylw.basics.zuul.chain.handler.impl;

import com.netflix.zuul.context.RequestContext;
import com.ylw.basics.zuul.chain.handler.GatewayHandler;
import com.ylw.basics.zuul.chain.handler.impl.base.BaseHandler;
import com.ylw.common.web.core.sign.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * description: MD5验签handler
 * create by: YangLinWei
 * create time: 2020/5/21 3:49 下午
 */
@Component
@Slf4j
public class VerifySignHandler extends BaseHandler implements GatewayHandler {
    @Override
    public Boolean service(RequestContext ctx, String ipAddres, HttpServletRequest request, HttpServletResponse response) {
        // 4.外网传递参数验证
        Map<String, String> verifyMap = SignUtil.toVerifyMap(request.getParameterMap(), false);
        if (!SignUtil.verify(verifyMap)) {
            resultError(ctx, "ip:" + ipAddres + ",Sign fail");
            return Boolean.FALSE;
        }
        if (gatewayHandler != null) {
            gatewayHandler.service(ctx, ipAddres, request, response);
        }
        return Boolean.TRUE;
    }

}
