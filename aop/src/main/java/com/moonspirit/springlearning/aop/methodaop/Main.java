package com.moonspirit.springlearning.aop.methodaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName      Main
 * @Description    执行入口
 *
 * @author         moonspirit
 * @date           2018年7月20日    下午2:43:49
 * @version        1.0.0
 */
public class Main {

	/**
	 * @MethodName       main
	 * @Description      TODO
	 *
	 * @param            @param args
	 * @return           void
	 * @throws
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MethodService methodService = context.getBean(MethodService.class);
		methodService.add();
		context.close();
	}
}
