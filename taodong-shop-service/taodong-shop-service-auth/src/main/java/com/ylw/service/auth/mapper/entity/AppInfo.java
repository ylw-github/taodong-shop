package com.ylw.service.auth.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AppInfo implements Serializable, Cloneable {
	/** 主键ID */
	private Integer id;
	/** 应用名称 */
	private String appName;
	/** 应用id */
	private String appId;
	/** 应用密钥 */
	private String appSecret;
	/** 是否可用 */
	private String availability;

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
}