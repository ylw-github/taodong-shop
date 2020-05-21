package com.ylw.basics.zuul.chain.handler.impl;

import com.netflix.zuul.context.RequestContext;
import com.ylw.basics.zuul.chain.handler.GatewayHandler;
import com.ylw.basics.zuul.chain.handler.impl.base.BaseHandler;
import com.ylw.basics.zuul.mapper.BlacklistMapper;
import com.ylw.basics.zuul.mapper.entity.Blacklist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: 黑名单处理handler
 * create by: YangLinWei
 * create time: 2020/5/21 3:37 下午
 */
@Component
@Slf4j
public class BlackListHandler extends BaseHandler implements GatewayHandler {
    @Autowired
    private BlacklistMapper blacklistMapper;

    @Override
    public Boolean service(RequestContext ctx, String ipAddres, HttpServletRequest request, HttpServletResponse response) {
        // 2.查询数据库黑名单
        Blacklist blacklist = blacklistMapper.findBlacklist(ipAddres);
        if (blacklist != null) {
            resultError(ctx, "ip:" + ipAddres + ",Insufficient access rights");
            return Boolean.FALSE;
        }
        log.info(">>>>>>ip:{},验证通过>>>>>>>", ipAddres);
        // 3.将ip地址传递到转发服务中
        response.addHeader("ipAddres", ipAddres);
        log.info(">>>>>>ip:{},验证通过>>>>>>>", ipAddres);
        if (gatewayHandler != null) {
            gatewayHandler.service(ctx, ipAddres, request, response);
        }
        return Boolean.TRUE;
    }
}
