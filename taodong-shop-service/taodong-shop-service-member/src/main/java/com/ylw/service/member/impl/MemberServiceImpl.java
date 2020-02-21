package com.ylw.service.member.impl;


import com.ylw.service.api.member.MemberService;
import com.ylw.api.weixin.entity.AppEntity;
import com.ylw.service.member.feign.AppServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl implements MemberService {
	@Autowired
	private AppServiceFeign appServiceFeign;

	@GetMapping("/memberInvokWeixin")
	public AppEntity memberInvokWeixin() {
		return appServiceFeign.getApp();
	}

}
