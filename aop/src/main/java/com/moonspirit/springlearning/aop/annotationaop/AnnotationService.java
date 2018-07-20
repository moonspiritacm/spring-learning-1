package com.moonspirit.springlearning.aop.annotationaop;

import org.springframework.stereotype.Service;

/**
 * @ClassName      AnnotationService
 * @Description    基于注解的被拦截类，在连接点位置添加自定义注解
 *
 * @author         moonspirit
 * @date           2018年7月19日    上午10:45:45
 * @version        1.0.0
 */
@Service
public class AnnotationService {

	@Action(name = "自定义注解")
	public void add() {
		System.out.println("正在执行 AnnotationService.add() 方法");
	}
}
