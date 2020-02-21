package com.ylw.service.member.impl;


import com.ylw.api.member.entity.UserEntity;
import com.ylw.common.core.api.BaseApiService;
import com.ylw.common.core.constants.Constants;
import com.ylw.common.core.entity.BaseResponse;
import com.ylw.service.api.member.MemberService;
import com.ylw.service.member.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl extends BaseApiService<UserEntity> implements MemberService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public BaseResponse<UserEntity> existMobile(String mobile) {
		// 1.验证参数
		if (StringUtils.isEmpty(mobile)) {
			return setResultError("手机号码不能为空!");
		}
		// 2.根据手机号码查询用户信息 单独定义code 表示是用户信息不存在把
		UserEntity userEntity = userMapper.existMobile(mobile);
		if (userEntity == null) {
			return setResultError(Constants.HTTP_RES_CODE_EXISTMOBILE_203, "用户信息不存在!");
		}
		// 对特殊铭感字段需要做脱敏
		userEntity.setPassword(null);
		return setResultSuccess(userEntity);
	}
}
