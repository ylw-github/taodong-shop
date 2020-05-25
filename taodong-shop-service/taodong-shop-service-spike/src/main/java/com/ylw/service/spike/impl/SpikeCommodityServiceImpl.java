package com.ylw.service.spike.impl;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.web.core.api.BaseApiService;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.common.web.core.util.RedisUtil;
import com.ylw.service.api.spike.SpikeCommodityService;
import com.ylw.service.spike.mapper.OrderMapper;
import com.ylw.service.spike.mapper.SeckillMapper;
import com.ylw.service.spike.mapper.entity.OrderEntity;
import com.ylw.service.spike.mapper.entity.SeckillEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SpikeCommodityServiceImpl extends BaseApiService<JSONObject> implements SpikeCommodityService {
	@Autowired
	private SeckillMapper seckillMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private RedisUtil redisUtil;

	@Override
	@Transactional
	public BaseResponse<JSONObject> spike(String phone, Long seckillId) {
		// 1.参数验证
		if (StringUtils.isEmpty(phone)) {
			return setResultError("手机号码不能为空!");
		}
		if (seckillId == null) {
			return setResultError("商品库存id不能为空!");
		}
		SeckillEntity seckillEntity = seckillMapper.findBySeckillId(seckillId);
		if (seckillEntity == null) {
			return setResultError("商品信息不存在!");
		}
		// 2.用户频率限制 setnx 如果key存在话

		Boolean reusltNx = redisUtil.setNx(phone, seckillId + "", 10l);
		if (!reusltNx) {
			return setResultError("访问次数过多，10秒后在实现重试!");
		}
		// 3.（悲观锁 ）修改数据库对应的库存 1万中只有100个抢购成功 提前生成好100个token 谁能够抢购成功token放入到mq中实现异步修改库存
		/*int inventoryDeduction = seckillMapper.pessimisticDeduction(seckillId);
		if (!toDaoResult(inventoryDeduction)) {
			log.info(">>>修改库存失败>>>>inventoryDeduction返回为{} 秒杀失败！", inventoryDeduction);
			return setResultError("亲，请稍后重试!");
		}*/

		// 3.（乐观锁 ）修改数据库对应的库存 1万中只有100个抢购成功 提前生成好100个token 谁能够抢购成功token放入到mq中实现异步修改库存
		Long version = seckillEntity.getVersion();
		int inventoryDeduction = seckillMapper.optimisticDeduction(seckillId, version);
		if (!toDaoResult(inventoryDeduction)) {
			log.info(">>>修改库存失败>>>>inventoryDeduction返回为{} 秒杀失败！", inventoryDeduction);
			return setResultError("亲，请稍后重试!");
		}
		// 4.添加秒杀成功订单 基于MQ实现异步形式
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setUserPhone(phone);
		orderEntity.setSeckillId(seckillId);
		int insertOrder = orderMapper.insertOrder(orderEntity);
		if (!toDaoResult(insertOrder)) {
			return setResultError("亲，请稍后重试!");
		}
		log.info(">>>修改库存成功>>>>inventoryDeduction返回为{} 秒杀成功", inventoryDeduction);
		return setResultSuccess("恭喜您，秒杀成功!");
	}

}
