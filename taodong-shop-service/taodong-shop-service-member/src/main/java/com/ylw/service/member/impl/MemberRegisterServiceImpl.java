package com.ylw.service.member.impl;

import com.alibaba.fastjson.JSONObject;
import com.ylw.api.member.entity.UserEntity;
import com.ylw.common.core.api.BaseApiService;
import com.ylw.common.core.constants.Constants;
import com.ylw.common.core.entity.BaseResponse;
import com.ylw.common.core.util.MD5Util;
import com.ylw.service.api.member.MemberRegisterService;
import com.ylw.service.member.feign.VerificaCodeServiceFeign;
import com.ylw.service.member.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRegisterServiceImpl extends BaseApiService<JSONObject> implements MemberRegisterService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private VerificaCodeServiceFeign verificaCodeServiceFeign;

	@Transactional
	public BaseResponse<JSONObject> register(@RequestBody UserEntity userEntity, String registCode) {
		// 1.参数验证
		String userName = userEntity.getUserName();
		if (StringUtils.isEmpty(userName)) {
			return setResultError("用户名称不能为空!");
		}
		String mobile = userEntity.getMobile();
		if (StringUtils.isEmpty(mobile)) {
			return setResultError("手机号码不能为空!");
		}
		String password = userEntity.getPassword();
		if (StringUtils.isEmpty(password)) {
			return setResultError("密码不能为空!");
		}
		// 2.验证码注册码是否正确 暂时省略 会员调用微信接口实现注册码验证
		BaseResponse<JSONObject> verificaWeixinCode = verificaCodeServiceFeign.verificaWeixinCode(mobile, registCode);
		if (!verificaWeixinCode.getCode().equals(Constants.HTTP_RES_CODE_200)) {
			return setResultError(verificaWeixinCode.getMsg());
		}
		// 3.对用户的密码进行加密 // MD5 可以解密 暴力破解
		String newPassword = MD5Util.MD5(password);
		userEntity.setPassword(newPassword);
		// 4.调用数据库插入数据
		return userMapper.register(userEntity) > 0 ? setResultSuccess("注册成功") : setResultError("注册失败!");
	}

}
