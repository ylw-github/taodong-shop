package com.ylw.service.auth.impl;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.web.core.api.BaseApiService;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.common.web.core.util.GenerateToken;
import com.ylw.service.api.auth.AuthorizationService;
import com.ylw.service.auth.mapper.AppInfoMapper;
import com.ylw.service.auth.mapper.entity.AppInfo;
import com.ylw.service.auth.utils.Guid;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationServiceImpl extends BaseApiService<JSONObject> implements AuthorizationService {
	@Autowired
	private AppInfoMapper appInfoMapper;
	@Autowired
	private GenerateToken generateToken;

	@Override
	public BaseResponse<JSONObject> applyAppInfo(String appName) {
		// 1.验证参数
		if (StringUtils.isEmpty(appName)) {
			return setResultError("机构名称不能为空!");
		}
		// 2.生成appid和appScrec
		Guid guid = new Guid();
		String appId = guid.getAppId();
		String appScrect = guid.getAppScrect();
		// 3.添加数据库中
		AppInfo appInfo = new AppInfo();
		appInfo.setAppName(appName);
		appInfo.setAppId(appId);
		appInfo.setAppSecret(appScrect);
		int insertAppInfo = appInfoMapper.insertAppInfo(appInfo);
		if (!toDaoResult(insertAppInfo)) {
			return setResultError("申请失败!");
		}
		// 4.返回给客户端
		JSONObject data = new JSONObject();
		data.put("appId", appId);
		data.put("appScrect", appScrect);
		return setResultSuccess(data);
	}

	@Override
	public BaseResponse<JSONObject> getAccessToken(String appId, String appSecret) {
		// 使用appid+appSecret获取AccessToken
		// 1.参数验证
		if (StringUtils.isEmpty(appId)) {
			return setResultError("appId不能为空!");
		}
		if (StringUtils.isEmpty(appSecret)) {
			return setResultError("appSecret不能为空!");
		}
		// 2.使用appId+appSecret查询数据库
		AppInfo appInfo = appInfoMapper.selectByAppInfo(appId, appSecret);
		if (appInfo == null) {
			return setResultError("appId或者是appSecret错误");
		}
		// 3.获取应用机构信息 生成accessToken
		String dbAppId = appInfo.getAppId();
		String accessToken = generateToken.createToken("auth", dbAppId);
		JSONObject data = new JSONObject();
		data.put("accessToken", accessToken);
		return setResultSuccess(data);
	}

	@Override
	public BaseResponse<JSONObject> getAppInfo(String accessToken) {
		// 1.验证参数
		if (StringUtils.isEmpty(accessToken)) {
			return setResultError("AccessToken cannot be empty ");
		}
		// 2.从redis中获取accessToken
		String appId = generateToken.getToken(accessToken);
		if (StringUtils.isEmpty(appId)) {
			return setResultError("accessToken  invalid");
		}
		// 3.使用appid查询数据库
		AppInfo appInfo = appInfoMapper.findByAppInfo(appId);
		if (appInfo == null) {
			return setResultError("AccessToken  invalid");
		}
		// 4.返回应用机构信息
		JSONObject data = new JSONObject();
		data.put("appInfo", appInfo);
		return setResultSuccess(data);
	}
}
