package com.moonspirit.springlearning.setting.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ClassName      Config
 * @Description    配置类，使用注解 @Profile("") 配置 bean 加载环境，只有当选择对应的环境时，才会产生对应的 bean
 *
 * @author         moonspirit
 * @date           2018年7月20日    下午3:26:41
 * @version        1.0.0
 */
@Configuration
public class Config {

	/**
	 * @MethodName       devBasicBean
	 * @Description      profile 为 dev 时执行该实例化方法
	 *
	 * @param            @return
	 * @return           BasicBean
	 * @throws
	 */
	@Bean
	@Profile("dev")
	public BasicBean devBasicBean() {
		return new BasicBean("development profile");
	}

	/**
	 * @MethodName       portableBasicBean
	 * @Description      profile 为 portable 时执行该实例化方法
	 *
	 * @param            @return
	 * @return           BasicBean
	 * @throws
	 */
	@Bean
	@Profile("portable")
	public BasicBean portableBasicBean() {
		return new BasicBean("portable profile");
	}
}
