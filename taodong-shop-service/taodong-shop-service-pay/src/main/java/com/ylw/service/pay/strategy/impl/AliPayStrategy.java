package com.ylw.service.pay.strategy.impl;

import com.ylw.api.pay.dto.dto.PayMentTransacDTO;
import com.ylw.service.pay.mapper.entity.PaymentChannelEntity;
import com.ylw.service.pay.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * description: 支付宝支付渠道
 * create by: YangLinWei
 * create time: 2020/5/13 4:41 下午
 */
@Slf4j
public class AliPayStrategy implements PayStrategy {

	@Override
	public String toPayHtml(PaymentChannelEntity pymentChannel, PayMentTransacDTO payMentTransacDTO) {
		log.info(">>>>>支付宝参数封装开始<<<<<<<<");
		return "支付宝支付from表单提交";
	}

}