package com.ylw.portal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description: 首页
 * create by: YangLinWei
 * create time: 2020/3/5 1:48 下午
 */
@Controller
public class IndexController {

	/**
	 * 跳转到首页
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * 跳转到首页
	 * 
	 * @return
	 */
	@RequestMapping("/index.html")
	public String indexHtml() {
		return index();
	}
}
