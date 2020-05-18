package com.ylw.service.pay.callback.service;

import com.alipay.api.AlipayApiException;
import com.ylw.service.pay.callback.template.AbstractPayCallbackTemplate;
import com.ylw.service.pay.callback.template.factory.TemplateFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@RestController
public class PayAsynCallbackService {
	private static final String UNIONPAYCALLBACK_TEMPLATE = "unionPayCallbackTemplate";
	private static final String ALIPAYCALLBACK_TEMPLATE = "aliPayCallbackTemplate";
	/**
	 * 银联同步回调接口执行代码
	 *
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/unionPaySynCallback")
	public String unionPaySynCallback(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, AlipayApiException {
		AbstractPayCallbackTemplate abstractPayCallbackTemplate = TemplateFactory
				.getPayCallbackTemplate(UNIONPAYCALLBACK_TEMPLATE);
		return abstractPayCallbackTemplate.syncService(req, resp);
	}


	/**
	 * 银联异步回调接口执行代码
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/unionPayAsynCallback")
	public String unionPayAsynCallback(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, AlipayApiException {
		AbstractPayCallbackTemplate abstractPayCallbackTemplate = TemplateFactory
				.getPayCallbackTemplate(UNIONPAYCALLBACK_TEMPLATE);
		return abstractPayCallbackTemplate.asyncCallBack(req, resp);
	}

	/**
	 * description: 阿里同步回调接口执行代码
	 * create by: YangLinWei
	 * create time: 2020/5/18 10:08 上午
	 */
	@RequestMapping("/aliPaySynCallback")
	public String aliPaySynCallback(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, AlipayApiException {
		AbstractPayCallbackTemplate abstractPayCallbackTemplate = TemplateFactory
				.getPayCallbackTemplate(ALIPAYCALLBACK_TEMPLATE);
		return abstractPayCallbackTemplate.syncService(req, resp);
	}

	/**
	 * description: 阿里异步回调接口执行代码
	 * create by: YangLinWei
	 * create time: 2020/5/18 10:08 上午
	 */
	@RequestMapping("/aliPayAsynCallback")
	public String aliPayAsynCallback(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, AlipayApiException {
		AbstractPayCallbackTemplate abstractPayCallbackTemplate = TemplateFactory
				.getPayCallbackTemplate(ALIPAYCALLBACK_TEMPLATE);
		return abstractPayCallbackTemplate.asyncCallBack(req, resp);
	}

}
