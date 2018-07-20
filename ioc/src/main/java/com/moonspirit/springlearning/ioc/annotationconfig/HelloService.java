package com.moonspirit.springlearning.ioc.annotationconfig;

import org.springframework.stereotype.Service;

/**
 * @ClassName      HelloService
 * @Description    实体类，位于业务逻辑层，使用注解 @Service 声明
 *
 * @author         moonspirit
 * @date           2018年7月18日    上午10:58:38
 * @version        1.0.0
 */
@Service
public class HelloService {

	/**
	 * @MethodName       sayHello
	 * @Description      TODO
	 *
	 * @param            name
	 * @return           String
	 * @throws
	 */
	public String sayHello(String name) {
		return "Hello " + name + "!";
	}
}
