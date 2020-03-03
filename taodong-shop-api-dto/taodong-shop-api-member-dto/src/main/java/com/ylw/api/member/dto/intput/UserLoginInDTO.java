package com.ylw.api.member.dto.intput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 用户登录请求参数
 * create by: YangLinWei
 * create time: 2020/3/3 4:37 下午
 */
@Data
@ApiModel(value = "用户登录参数")
public class UserLoginInDTO {
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String mobile;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 登陆类型 PC、Android 、IOS
     */
    @ApiModelProperty(value = "登陆类型")
    private String loginType;
    /**
     * 设备信息
     */
    @ApiModelProperty(value = "设备信息")
    private String deviceInfor;

}
