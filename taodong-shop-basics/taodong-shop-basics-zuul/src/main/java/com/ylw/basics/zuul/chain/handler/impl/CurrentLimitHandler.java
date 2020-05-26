package com.ylw.basics.zuul.chain.handler.impl;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.context.RequestContext;
import com.ylw.basics.zuul.chain.handler.GatewayHandler;
import com.ylw.basics.zuul.chain.handler.impl.base.BaseHandler;
import com.ylw.common.web.core.util.GenerateToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * description: 服务限流
 * create by: YangLinWei
 * create time: 2020/5/26 3:00 下午
 */
@Component
@Slf4j
public class CurrentLimitHandler extends BaseHandler implements GatewayHandler {
    private RateLimiter rateLimiter = RateLimiter.create(1);

    @Autowired
    private GenerateToken generateToken;


    @Override
    public Boolean service(RequestContext ctx, String ipAddres, HttpServletRequest request, HttpServletResponse response) {
        // 1.用户限流频率设置 每秒中限制1个请求
        boolean tryAcquire = rateLimiter.tryAcquire(0, TimeUnit.SECONDS);
        if (!tryAcquire) {
            resultError(ctx, "There are too many people snapping up goods now. Please wait a moment!");
            return Boolean.FALSE;
        }
        // 2.使用redis限制用户访问频率
        String seckillId = request.getParameter("seckillId");
        String seckillToken = generateToken.getListKeyToken(seckillId + "");
        if (StringUtils.isEmpty(seckillToken)) {
            log.info(">>>seckillId:{}, The second kill has sold out, please come again next time!", seckillId);
            resultError(ctx, "The second kill has sold out, please come again next time!");
            return Boolean.FALSE;
        }
        if (gatewayHandler != null) {
            gatewayHandler.service(ctx, ipAddres, request, response);
        }
        return Boolean.TRUE;
    }
}
