package com.ylw.basics.zuul.build;

import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GatewayDirector {
	@Resource(name = "verificationBuild")
	private GatewayBuild gatewayBuild;

	public void direcot(RequestContext ctx, String ipAddres, HttpServletResponse response, HttpServletRequest request) {
		/**
		 * 黑名单拦截
		 */
		Boolean blackBlock = gatewayBuild.blackBlock(ctx, ipAddres, response);
		if (!blackBlock) {
			return;
		}
		/**
		 * 参数验证
		 */
		Boolean verifyMap = gatewayBuild.toVerifyMap(ctx, ipAddres, request);
		if (!verifyMap) {
			return;
		}
	}

}
