package com.ylw.service.spike.mapper;

import com.ylw.service.spike.mapper.entity.OrderEntity;
import org.apache.ibatis.annotations.Insert;

public interface OrderMapper {

	@Insert("INSERT INTO `order` VALUES (#{seckillId},#{userPhone}, '1', now());")
	int insertOrder(OrderEntity orderEntity);
}
