package com.ylw.service.member.impl;

import com.alibaba.fastjson.JSONObject;
import com.ylw.api.member.dto.intput.UserLoginInDTO;
import com.ylw.common.core.api.BaseApiService;
import com.ylw.common.core.constants.Constants;
import com.ylw.common.core.entity.BaseResponse;
import com.ylw.common.core.util.GenerateToken;
import com.ylw.common.core.util.MD5Util;
import com.ylw.service.api.member.MemberLoginService;
import com.ylw.service.member.mapper.UserMapper;
import com.ylw.service.member.mapper.UserTokenMapper;
import com.ylw.service.member.mapper.entity.UserDo;
import com.ylw.service.member.mapper.entity.UserTokenDo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberLoginServiceImpl extends BaseApiService<JSONObject> implements MemberLoginService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private GenerateToken generateToken;
	@Autowired
	private UserTokenMapper userTokenMapper;

	@Override
	public BaseResponse<JSONObject> login(@RequestBody UserLoginInDTO userLoginInpDTO) {
		// 1.验证参数
		String mobile = userLoginInpDTO.getMobile();
		if (StringUtils.isEmpty(mobile)) {
			return setResultError("手机号码不能为空!");
		}
		String password = userLoginInpDTO.getPassword();
		if (StringUtils.isEmpty(password)) {
			return setResultError("密码不能为空!");
		}
		// 判断登陆类型
		String loginType = userLoginInpDTO.getLoginType();
		if (StringUtils.isEmpty(loginType)) {
			return setResultError("登陆类型不能为空!");
		}
		// 目的是限制范围
		if (!(loginType.equals(Constants.MEMBER_LOGIN_TYPE_ANDROID) || loginType.equals(Constants.MEMBER_LOGIN_TYPE_IOS)
				|| loginType.equals(Constants.MEMBER_LOGIN_TYPE_PC))) {
			return setResultError("登陆类型出现错误!");
		}

		// 设备信息
		String deviceInfor = userLoginInpDTO.getDeviceInfor();
		if (StringUtils.isEmpty(deviceInfor)) {
			return setResultError("设备信息不能为空!");
		}

		// 2.对登陆密码实现加密
		String newPassWord = MD5Util.MD5(password);
		// 3.使用手机号码+密码查询数据库 ，判断用户是否存在
		UserDo userDo = userMapper.login(mobile, newPassWord);
		if (userDo == null) {
			return setResultError("用户名称或者密码错误!");
		}
		// 用户登陆Token Session 区别
		// 用户每一个端登陆成功之后，会对应生成一个token令牌（临时且唯一）存放在redis中作为rediskey value userid
		// 4.获取userid
		Long userId = userDo.getUserId();
		// 5.根据userId+loginType 查询当前登陆类型账号之前是否有登陆过，如果登陆过 清除之前redistoken
		UserTokenDo userTokenDo = userTokenMapper.selectByUserIdAndLoginType(userId, loginType);
		if (userTokenDo != null) {
			// 如果登陆过 清除之前redistoken
			String token = userTokenDo.getToken();
			Boolean isremoveToken = generateToken.removeToken(token);
			if (isremoveToken) {
			 // 把该token的状态改为1
			 userTokenMapper.updateTokenAvailability(token);
			}

		}

		// .生成对应用户令牌存放在redis中
		String keyPrefix = Constants.MEMBER_TOKEN_KEYPREFIX + loginType;
		String newToken = generateToken.createToken(keyPrefix, userId + "");

		// 1.插入新的token
		UserTokenDo userToken = new UserTokenDo();
		userToken.setUserId(userId);
		userToken.setLoginType(userLoginInpDTO.getLoginType());
		userToken.setToken(newToken);
		userToken.setDeviceInfor(deviceInfor);
		userTokenMapper.insertUserToken(userToken);
		JSONObject data = new JSONObject();
		data.put("token", newToken);

		return setResultSuccess(data);
	}

}
