package com.ylw.service.api.pay;

import com.alibaba.fastjson.JSONObject;
import com.ylw.api.pay.dto.dto.PayCratePayTokenDto;
import com.ylw.common.web.core.entity.BaseResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * description: 支付交易服务接口
 * create by: YangLinWei
 * create time: 2020/5/13 11:29 上午
 */
public interface PayMentTransacTokenService {

	/**
	 * 创建支付令牌
	 * 
	 * @return
	 */
	@GetMapping("/cratePayToken")
	public BaseResponse<JSONObject> cratePayToken(@Validated PayCratePayTokenDto payCratePayTokenDto);

}
