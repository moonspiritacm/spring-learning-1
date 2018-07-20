package com.moonspirit.springlearning.setting.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

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
