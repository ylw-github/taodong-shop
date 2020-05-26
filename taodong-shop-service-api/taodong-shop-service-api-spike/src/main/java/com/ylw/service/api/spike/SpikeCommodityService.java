package com.ylw.service.api.spike;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.web.core.entity.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description: 秒杀商品服务接口
 * create by: YangLinWei
 * create time: 2020/5/26 10:42 上午
 */
public interface SpikeCommodityService {


	/**
	 * 新增对应商品库存令牌桶
	 *
	 * @seckillId 商品库存id
	 */
	@RequestMapping("/addSpikeToken")
	public BaseResponse<JSONObject> addSpikeToken(Long seckillId, Long tokenQuantity);

	/**
	 * 用户秒杀接口 phone和userid都可以的
	 * 
	 * @phone 手机号码<br>
	 * @seckillId 库存id
	 * @return
	 */
	@RequestMapping("/spike")
	public BaseResponse<JSONObject> spike(String phone, Long seckillId);


}
