package com.moonspirit.springlearning.ioc.javaconfig;

/**
 * @ClassName      InvokeService
 * @Description    实体类，依赖 HelloService 实现功能，不使用注解声明
 *
 * @author         moonspirit
 * @date           2018年7月18日    上午10:59:31
 * @version        1.0.0
 */
public class InvokeService {

	HelloService helloService;

	/**
	 * @MethodName       setHelloService
	 * @Description      TODO
	 *
	 * @param            helloService
	 * @return           void
	 * @throws
	 */
	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}

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
