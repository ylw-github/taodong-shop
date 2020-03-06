package com.ylw.portal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * description: 注册页
 * create by: YangLinWei
 * create time: 2020/3/5 1:48 下午
 */
@Controller
public class RegisterController {
	private static final String MEMBER_REGISTER_PAGE = "member/register";

	/**
	 * 跳转到注册页面
	 * 
	 * @return
	 */
	@GetMapping("/register.html")
	public String getRegister() {
		return MEMBER_REGISTER_PAGE;
	}

	/**
	 * 跳转到注册页面
	 * 
	 * @return
	 */
	@PostMapping("/register.html")
	public String postRegister() {
		return null;
	}

}
