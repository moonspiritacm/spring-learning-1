package com.moonspirit.springlearning.ioc.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName      JavaConfig
 * @Description    配置类，管理依赖注入，大量使用注解
 *
 * @author         moonspirit
 * @date           2018年7月18日    上午10:56:26
 * @version        1.0.0
 */
@Configuration
public class JavaConfig {

	/**
	 * @MethodName       helloService
	 * @Description      配置实体类
	 *
	 * @param
	 * @return           HelloService
	 * @throws
	 */
	@Bean
	public HelloService helloService() {
		return new HelloService();
	}

	/**
	 * @MethodName       invokeService
	 * @Description      配置依赖装载
	 *
	 * @param
	 * @return           InvokeService
	 * @throws
	 */
	@Bean
	public InvokeService invokeService() {
		InvokeService invokeService = new InvokeService();
		invokeService.setHelloService(helloService());
		return invokeService;
	}
}
