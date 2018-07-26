package com.moonspirit.springlearning.setting.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName      Main
 * @Description    执行入口
 *
 * @author         moonspirit
 * @date           2018年7月20日    下午3:58:40
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
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// context.getEnvironment().setActiveProfiles("portable");
		context.getEnvironment().setActiveProfiles("dev");
		context.register(Config.class);
		context.refresh();
		BasicBean basicBean = context.getBean(BasicBean.class);
		System.out.println(basicBean.getContent());
		context.close();
	}
}
