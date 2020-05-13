package com.ylw.common.web.core.util.twitter;

/**
 * description: 使用雪花算法生成全局id
 * create by: YangLinWei
 * create time: 2020/5/13 11:45 上午
 */
public class SnowflakeIdUtils {
	private static SnowflakeIdWorker idWorker;
	static {
		// 使用静态代码块初始化 SnowflakeIdWorker
		idWorker = new SnowflakeIdWorker(1, 1);
	}

	public static String nextId() {
		return idWorker.nextId() + "";
	}

}
