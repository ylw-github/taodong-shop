package com.ylw.service.spike.mapper;

import com.ylw.service.spike.mapper.entity.OrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

	@Insert("INSERT INTO `td_order` VALUES (#{seckillId},#{userPhone}, '1', now());")
	int insertOrder(OrderEntity orderEntity);

	@Select("SELECT seckill_id AS seckillid,user_phone as userPhone , state as state FROM td_order WHERE USER_PHONE=#{phone}  and seckill_id=#{seckillId}  AND STATE='1';")
	List<OrderEntity> findByOrder(@Param("phone") String phone, @Param("seckillId") Long seckillId);
}
