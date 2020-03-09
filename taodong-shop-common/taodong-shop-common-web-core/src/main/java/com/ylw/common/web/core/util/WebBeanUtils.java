package com.ylw.common.web.core.util;

/**
 * description: vo转换工具类
 * create by: YangLinWei
 * create time: 2020/3/9 11:37 上午
 */
public class WebBeanUtils<Vo, Dto> {

	/**
	 * dot 转换为Do 工具类
	 * 
	 * @param voEntity
	 * @param dtoClass
	 * @return
	 */
	public static <Dto> Dto voToDto(Object voEntity, Class<Dto> dtoClass) {
		// 判断VoSF是否为空!
		if (voEntity == null) {
			return null;
		}
		// 判断DtoClass 是否为空
		if (dtoClass == null) {
			return null;
		}
		try {
			Dto newInstance = dtoClass.newInstance();
			org.springframework.beans.BeanUtils.copyProperties(voEntity, newInstance);
			// Dto转换Do
			return newInstance;
		} catch (Exception e) {
			return null;
		}
	}

}
