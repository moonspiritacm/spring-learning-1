package com.moonspirit.springlearning.ioc.annotationconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName      Main
 * @Description    执行入口
 *
 * @author         moonspirit
 * @date           2018年7月18日    上午11:00:57
 * @version        1.0.0
 */
public class Main {

	/**
	 * @MethodName       main
	 * @Description      TODO
	 *
	 * @param            args
	 * @return           void
	 * @throws
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		InvokeService invokeService = context.getBean(InvokeService.class);
		System.out.println(invokeService.invokeHello("world"));
		context.close();
	}
}
