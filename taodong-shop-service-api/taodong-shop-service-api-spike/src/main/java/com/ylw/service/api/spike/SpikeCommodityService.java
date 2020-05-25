package com.ylw.service.api.spike;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.web.core.entity.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description: 秒杀商品服务接口
 * create by: YangLinWei
 * create time: 2020/5/25 4:51 下午
 */
public interface SpikeCommodityService {

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
