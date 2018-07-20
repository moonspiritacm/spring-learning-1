package com.moonspirit.springlearning.aop.methodaop;

import org.springframework.stereotype.Service;

/**
 * @ClassName      MethodService
 * @Description    基于方法规则的被拦截类，不使用注解声明连接点
 *
 * @author         moonspirit
 * @date           2018年7月18日    下午3:04:05
 * @version        1.0.0
 */
@Service
public class MethodService {

	public void add() {
		System.out.println("正在执行 MethodService.add() 方法");
	}
}
