package com.ylw.api.pay.dto.dto;

import lombok.Data;

@Data
public class PaymentChannelDTO {
	/** ID */
	private Integer id;
	/** 渠道名称 */
	private String channelName;
	/** 渠道ID */
	private String channelId;
	/** 商户id */
	private String merchantId;
	/** 同步回调URL */
	private String syncUrl;
	/** 异步回调URL */
	private String asynUrl;
	/** 公钥 */
	private String publicKey;
	/** 私钥 */
	private String privateKey;

	/**
	 * 接口实现地址
	 */
	private String classAddres;

}
