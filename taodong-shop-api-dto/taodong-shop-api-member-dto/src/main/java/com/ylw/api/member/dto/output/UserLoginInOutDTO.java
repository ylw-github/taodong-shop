package com.ylw.api.member.dto.output;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * description: 响应返回参数
 * create by: YangLinWei
 * create time: 2020/3/2 11:12 上午
 */
@Data
@ApiModel(value = "用户返回参数")
public class UserLoginInOutDTO {

	/**
	 * userid
	 */
	@ApiModelProperty(value = "用户id")
	private Long userId;
	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码")
	private String mobile;

	/**
	 * 用户名称
	 */
	@ApiModelProperty(value = "用户名称")
	private String userName;

}
