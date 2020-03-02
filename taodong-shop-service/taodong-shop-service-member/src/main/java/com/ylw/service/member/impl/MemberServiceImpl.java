package com.ylw.service.member.impl;


import com.ylw.api.member.dto.output.UserOutDTO;
import com.ylw.common.core.api.BaseApiService;
import com.ylw.common.core.constants.Constants;
import com.ylw.common.core.entity.BaseResponse;
import com.ylw.common.core.util.BeanUtils;
import com.ylw.service.api.member.MemberService;
import com.ylw.service.member.mapper.UserMapper;
import com.ylw.service.member.mapper.entity.UserDo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl extends BaseApiService<UserOutDTO> implements MemberService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public BaseResponse<UserOutDTO> existMobile(String mobile) {
		// 1.验证参数
		if (StringUtils.isEmpty(mobile)) {
			return setResultError("手机号码不能为空!");
		}

		// 2.根据手机号码查询用户信息 单独定义code 表示是用户信息不存在把
		UserDo userEntity = userMapper.existMobile(mobile);
		if (userEntity == null) {
			return setResultError(Constants.HTTP_RES_CODE_EXISTMOBILE_203, "用户信息不存在!");
		}
		// 3.将do转换成dto
		return setResultSuccess(BeanUtils.doToDto(userEntity, UserOutDTO.class));
	}

}
