package com.moonspirit.springlearning.aop.annotationaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName      Main
 * @Description    执行入口
 *
 * @author         moonspirit
 * @date           2018年7月19日    下午5:06:20
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
		AnnotationService annotationService = context.getBean(AnnotationService.class);
		annotationService.add();
		context.close();
	}
}
