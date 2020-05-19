package com.ylw.service.integral.mapper;

import com.ylw.service.integral.mapper.entity.IntegralEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * description: 积分Mapper
 * create by: YangLinWei
 * create time: 2020/5/19 2:09 下午
 */
public interface IntegralMapper {
	@Insert("INSERT INTO `integral` VALUES (NULL, #{userId}, #{paymentId},#{integral}, #{availability}, 0, null, now(), null, now());")
	public int insertIntegral(IntegralEntity eiteIntegralEntity);

	@Select("SELECT  id as id ,USER_ID as userId, PAYMENT_ID as PAYMENTID ,INTEGRAL as INTEGRAL ,AVAILABILITY as AVAILABILITY  FROM integral where PAYMENT_ID=#{paymentId}  AND AVAILABILITY='1';")
	public IntegralEntity findIntegral(String paymentId);
}
