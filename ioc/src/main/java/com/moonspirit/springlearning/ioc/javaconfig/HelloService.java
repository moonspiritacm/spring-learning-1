package com.moonspirit.springlearning.ioc.javaconfig;

/**
 * @ClassName      HelloService
 * @Description    实体类，不使用注解声明
 *
 * @author         moonspirit
 * @date           2018年7月18日    上午10:58:38
 * @version        1.0.0
 */
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
