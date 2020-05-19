package com.ylw.service.pay.mapper.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentChannelEntity {
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
	/** 渠道状态;0开启1关闭 */
	private Integer channelState;
	/** 乐观锁 */
	private Integer revision;
	/** 创建人 */
	private String createdBy;
	/** 创建时间 */
	private Date createdTime;
	/** 更新人 */
	private String updatedBy;
	/** 更新时间 */
	private Date updatedTime;

	/**
	 * 接口实现地址
	 */
	private String classAddres;

	private String retryBeanId;

}