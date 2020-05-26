package com.ylw.service.spike.impl;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.web.core.api.BaseApiService;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.service.api.spike.OrderSeckillService;
import com.ylw.service.spike.mapper.OrderMapper;
import com.ylw.service.spike.mapper.entity.OrderEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderSeckillServiceImpl extends BaseApiService<JSONObject> implements OrderSeckillService {
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public BaseResponse<JSONObject> getOrder(String phone, Long seckillId) {
		if (StringUtils.isEmpty(phone)) {
			return setResultError("手机号码不能为空!");
		}
		if (seckillId == null) {
			return setResultError("商品库存id不能为空!");
		}
		List<OrderEntity> orderEntity = orderMapper.findByOrder(phone, seckillId);
		if (orderEntity == null) {
			return setResultError("正在排队中.....");
		}
		return setResultSuccess("恭喜你秒杀成功!");
	}

}
