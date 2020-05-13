package com.ylw.service.pay.strategy.impl;

import com.ylw.api.pay.dto.dto.PayMentTransacDTO;
import com.ylw.service.pay.mapper.entity.PaymentChannelEntity;
import com.ylw.service.pay.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * description: 微信支付渠道
 * create by: YangLinWei
 * create time: 2020/5/13 5:10 下午
 */
@Slf4j
public class WeixinPayStrategy implements PayStrategy {

    @Override
    public String toPayHtml(PaymentChannelEntity pymentChannel, PayMentTransacDTO payMentTransacDTO) {
        log.info(">>>>>微信参数封装开始<<<<<<<<");
        // Plugin
        return "微信支付from表单提交";
    }

}
