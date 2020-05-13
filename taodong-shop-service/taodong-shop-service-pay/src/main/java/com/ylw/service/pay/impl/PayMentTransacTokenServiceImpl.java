package com.ylw.service.pay.impl;

import com.alibaba.fastjson.JSONObject;
import com.ylw.api.pay.dto.dto.PayCratePayTokenDto;
import com.ylw.common.web.core.api.BaseApiService;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.common.web.core.util.GenerateToken;
import com.ylw.common.web.core.util.twitter.SnowflakeIdUtils;
import com.ylw.service.api.pay.PayMentTransacTokenService;
import com.ylw.service.pay.mapper.PaymentTransactionMapper;
import com.ylw.service.pay.mapper.entity.PaymentTransactionEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class PayMentTransacTokenServiceImpl extends BaseApiService<JSONObject> implements PayMentTransacTokenService {
	@Autowired
	private PaymentTransactionMapper paymentTransactionMapper;

	@Autowired
	private GenerateToken generateToken;

	@Override
	public BaseResponse<JSONObject> cratePayToken(PayCratePayTokenDto payCratePayTokenDto) {
		String orderId = payCratePayTokenDto.getOrderId();
		if (StringUtils.isEmpty(orderId)) {
			return setResultError("订单号码不能为空!");
		}
		Long payAmount = payCratePayTokenDto.getPayAmount();
		if (payAmount == null) {
			return setResultError("金额不能为空!");
		}
		Long userId = payCratePayTokenDto.getUserId();
		if (userId == null) {
			return setResultError("userId不能为空!");
		}
		String productName = payCratePayTokenDto.getProductName();
		if (productName == null) {
			return setResultError("商品名称不能为空!");
		}
		// 2.将输入插入数据库中 待支付记录
		PaymentTransactionEntity paymentTransactionEntity = new PaymentTransactionEntity();
		paymentTransactionEntity.setOrderId(orderId);
		paymentTransactionEntity.setPayAmount(payAmount);
		paymentTransactionEntity.setUserId(userId);
		// 使用雪花算法 生成全局id
		paymentTransactionEntity.setPaymentId(SnowflakeIdUtils.nextId());
		paymentTransactionEntity.setProductName(productName);
		int result = paymentTransactionMapper.insertPaymentTransaction(paymentTransactionEntity);
		if (!toDaoResult(result)) {
			return setResultError("系统错误!");
		}
		// 获取主键id
		Long payId = paymentTransactionEntity.getId();
		if (payId == null) {
			return setResultError("系统错误!");
		}

		// 3.生成对应支付令牌
		String keyPrefix = "pay_";
		String token = generateToken.createToken(keyPrefix, payId + "");
		JSONObject dataResult = new JSONObject();
		dataResult.put("token", token);

		return setResultSuccess(dataResult);
	}

}
