package com.ylw.service.spike.mapper.entity;

import lombok.Data;

import java.util.Date;

/**
 * description: 秒杀成功订单
 * create by: YangLinWei
 * create time: 2020/5/25 4:54 下午
 */
@Data
public class OrderEntity {

	/**
	 * 库存id
	 * 
	 */
	private Long seckillId;
	/**
	 * 用户手机号码
	 */
	private String userPhone;
	/**
	 * 订单状态
	 */
	private Long state;
	/**
	 * 创建时间
	 */
	private Date createTime;
}
