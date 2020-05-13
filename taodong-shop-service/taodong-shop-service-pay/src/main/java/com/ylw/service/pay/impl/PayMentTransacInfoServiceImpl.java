package com.ylw.service.pay.impl;

import com.ylw.api.pay.dto.dto.PayMentTransacDTO;
import com.ylw.common.web.core.api.BaseApiService;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.common.web.core.util.BeanUtils;
import com.ylw.common.web.core.util.GenerateToken;
import com.ylw.service.api.pay.PayMentTransacInfoService;
import com.ylw.service.pay.mapper.PaymentTransactionMapper;
import com.ylw.service.pay.mapper.entity.PaymentTransactionEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayMentTransacInfoServiceImpl extends BaseApiService<PayMentTransacDTO>
		implements PayMentTransacInfoService {

	@Autowired
	private GenerateToken generateToken;

	@Autowired
	private PaymentTransactionMapper paymentTransactionMapper;

	@Override
	public BaseResponse<PayMentTransacDTO> tokenByPayMentTransac(String token) {
		// 1.验证token是否为空
		if (StringUtils.isEmpty(token)) {
			return setResultError("token参数不能空!");
		}
		// 2.使用token查询redisPayMentTransacID
		String value = generateToken.getToken(token);
		if (StringUtils.isEmpty(value)) {
			return setResultError("该Token可能已经失效或者已经过期");
		}
		// 3.转换为整数类型
		Long transactionId = Long.parseLong(value);
		// 4.使用transactionId查询支付信息
		PaymentTransactionEntity paymentTransaction = paymentTransactionMapper.selectById(transactionId);
		if (paymentTransaction == null) {
			return setResultError("未查询到该支付信息");
		}
		return setResultSuccess(BeanUtils.doToDto(paymentTransaction, PayMentTransacDTO.class));
	}

}
