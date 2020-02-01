package com.ylw.taodong.impl;


import com.ylw.taodong.entity.AppEntity;
import com.ylw.taodong.feign.AppServiceFeign;
import com.ylw.taodong.service.MemberService;
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
