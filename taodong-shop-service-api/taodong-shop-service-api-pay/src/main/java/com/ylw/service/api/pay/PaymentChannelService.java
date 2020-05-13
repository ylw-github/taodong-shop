package com.ylw.service.api.pay;

import com.ylw.api.pay.dto.dto.PaymentChannelDTO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * description: 支付渠道接口
 * create by: YangLinWei
 * create time: 2020/5/13 11:29 上午
 */
public interface PaymentChannelService {
	/**
	 * 查询所有支付渠道
	 * 
	 * @return
	 */
	@GetMapping("/selectAll")
	public List<PaymentChannelDTO> selectAll();
}
