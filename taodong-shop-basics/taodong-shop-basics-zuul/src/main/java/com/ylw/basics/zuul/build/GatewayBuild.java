package com.ylw.basics.zuul.build;

import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: 网关行为建造者
 * create by: YangLinWei
 * create time: 2020/5/20 9:09 上午
 */
public interface GatewayBuild {

	/**
	 * 黑名单拦截
	 */
	Boolean blackBlock(RequestContext ctx, String ipAddres, HttpServletResponse response);

	/**
	 * 参数验证
	 */
	Boolean toVerifyMap(RequestContext ctx, String ipAddres, HttpServletRequest request);

}
