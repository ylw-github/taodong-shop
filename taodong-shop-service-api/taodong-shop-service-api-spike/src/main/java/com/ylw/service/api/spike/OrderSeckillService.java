package com.ylw.service.api.spike;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.web.core.entity.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description: 查询秒杀记录
 * create by: YangLinWei
 * create time: 2020/5/26 10:42 上午
 */
public interface OrderSeckillService {

	@RequestMapping("/getOrder")
	public BaseResponse<JSONObject> getOrder(String phone, Long seckillId);

}
