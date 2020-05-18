package com.ylw.service.pay.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * description: springboot 整合线程池
 * create by: YangLinWei
 * create time: 2020/5/18 2:39 下午
 */
@Configuration
@EnableAsync
@Slf4j
public class AsyncTaskConfig implements AsyncConfigurer {

	/**
	 * 最小线程数(核心线程数)
	 */
	@Value("${threadPool.corePoolSize}")
	private int corePoolSize;
	/**
	 * 最大线程数
	 */
	@Value("${threadPool.maxPoolSize}")
	private int maxPoolSize;
	/**
	 * 等待队列(队列最大长度)
	 */
	@Value("${threadPool.queueCapacity}")
	private int queueCapacity;

	/**
	 * ThredPoolTaskExcutor的处理流程 当池子大小小于corePoolSize，就新建线程，并处理请求
	 * 当池子大小等于corePoolSize，把请求放入workQueue中，池子里的空闲线程就去workQueue中取任务并处理
	 * 当workQueue放不下任务时，就新建线程入池，并处理请求，如果池子大小撑到了maximumPoolSize，
	 * 就用RejectedExecutionHandler来做拒绝处理
	 * 当池子的线程数大于corePoolSize时，多余的线程会等待keepAliveTime长时间，如果无请求可处理就自行销毁
	 */
	@Override
	@Bean(name = "taskExecutor")
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		// 最小线程数(核心线程数)
		taskExecutor.setCorePoolSize(corePoolSize);
		// 最大线程数
		taskExecutor.setMaxPoolSize(maxPoolSize);
		// 等待队列(队列最大长度)
		taskExecutor.setQueueCapacity(queueCapacity);
		taskExecutor.initialize();
		return taskExecutor;
	}

	/**
	 * 异步异常处理
	 * 
	 * @return
	 */
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new SpringAsyncExceptionHandler();
	}

	class SpringAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
		@Override
		public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
			log.error("Exception occurs in async method", throwable.getMessage());
		}

	}
}
