package com.ylw.service.pay.callback.template.factory;

import com.ylw.common.web.core.util.SpringContextUtil;
import com.ylw.service.pay.callback.template.AbstractPayCallbackTemplate;

/**
 * description: 获取具体实现的模版工厂方案
 * create by: YangLinWei
 * create time: 2020/5/18 9:30 上午
 */
public class TemplateFactory {

	public static AbstractPayCallbackTemplate getPayCallbackTemplate(String beanId) {
		return (AbstractPayCallbackTemplate) SpringContextUtil.getBean(beanId);
	}

}
