package com.ylw.service.pay.strategy.impl;

import com.ylw.api.pay.dto.dto.PayMentTransacDTO;
import com.ylw.service.pay.mapper.entity.PaymentChannelEntity;
import com.ylw.service.pay.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * description: 银联支付渠道实现
 * create by: YangLinWei
 * create time: 2020/5/13 4:41 下午
 */
@Slf4j
public class UnionPayStrategy implements PayStrategy {

    @Override
    public String toPayHtml(PaymentChannelEntity pymentChannel, PayMentTransacDTO payMentTransacDTO) {
        log.info(">>>>>银联参数封装开始<<<<<<<<");
        // Plugin
        return "银联支付from表单提交";
    }

}
