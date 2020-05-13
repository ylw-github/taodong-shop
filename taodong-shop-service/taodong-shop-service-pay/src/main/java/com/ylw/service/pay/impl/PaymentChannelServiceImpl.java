package com.ylw.service.pay.impl;

import com.ylw.api.pay.dto.dto.PaymentChannelDTO;
import com.ylw.common.web.core.api.BaseApiService;
import com.ylw.common.web.core.util.MapperUtils;
import com.ylw.service.api.pay.PaymentChannelService;
import com.ylw.service.pay.mapper.PaymentChannelMapper;
import com.ylw.service.pay.mapper.entity.PaymentChannelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentChannelServiceImpl extends BaseApiService<List<PaymentChannelDTO>>
		implements PaymentChannelService {
	@Autowired
	private PaymentChannelMapper paymentChannelMapper;

	@Override
	public List<PaymentChannelDTO> selectAll() {
		List<PaymentChannelEntity> paymentChanneList = paymentChannelMapper.selectAll();
		return MapperUtils.mapAsList(paymentChanneList, PaymentChannelDTO.class);
	}

}
