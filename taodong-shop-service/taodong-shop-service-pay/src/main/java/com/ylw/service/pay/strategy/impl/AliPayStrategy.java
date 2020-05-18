package com.ylw.service.pay.strategy.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.ylw.api.pay.dto.dto.PayMentTransacDTO;
import com.ylw.service.pay.mapper.entity.PaymentChannelEntity;
import com.ylw.service.pay.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

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

		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);

		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(pymentChannel.getSyncUrl());
		alipayRequest.setNotifyUrl(pymentChannel.getAsynUrl());

		// 商户订单号，商户网站订单系统中唯一订单号，必填
		String outTradeNo = payMentTransacDTO.getPaymentId();
		// 付款金额，必填
		String totalAmount = changeF2Y(payMentTransacDTO.getPayAmount() + "");
		// 订单名称，必填
		String subject = payMentTransacDTO.getProductName();
		// 商品描述，可空
		String body = payMentTransacDTO.getProductName()+"很不错，值得购买！";

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\"," + "\"total_amount\":\"" + totalAmount
				+ "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		// 请求
		try {
			String result = alipayClient.pageExecute(alipayRequest).getBody();
			return result;
		} catch (Exception e) {
			return null;
		}

	}

	/** 金额为分的格式 */
	public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";

	/**
	 * 将分为单位的转换为元 （除100）
	 *
	 * @param amount
	 * @return
	 * @throws Exception
	 */
	public static String changeF2Y(String amount) {
		if (!amount.matches(CURRENCY_FEN_REGEX)) {
			return null;
		}
		return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();
	}

}