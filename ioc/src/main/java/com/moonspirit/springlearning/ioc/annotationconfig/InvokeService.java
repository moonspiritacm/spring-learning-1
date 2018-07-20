package com.moonspirit.springlearning.ioc.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName      InvokeService
 * @Description    实体类，依赖 HelloService 实现功能，使用注解 @Autowired 自动装配
 *
 * @author         moonspirit
 * @date           2018年7月18日    上午10:59:31
 * @version        1.0.0
 */
@Service
public class InvokeService {

	@Autowired
	HelloService helloService;

	/**
	 * @MethodName       invokeHello
	 * @Description      TODO
	 *
	 * @param            name
	 * @return           String
	 * @throws
	 */
	public String invokeHello(String name) {
		return helloService.sayHello(name);
	}
}
