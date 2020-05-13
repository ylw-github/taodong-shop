package com.ylw.service.api.pay;

import com.ylw.api.pay.dto.dto.PayMentTransacDTO;
import com.ylw.common.web.core.entity.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description: 支付记录接口
 * create by: YangLinWei
 * create time: 2020/5/13 11:29 上午
 */
public interface PayMentTransacInfoService {
	@GetMapping("/tokenByPayMentTransac")
	public BaseResponse<PayMentTransacDTO> tokenByPayMentTransac(@RequestParam("token") String token);
}
