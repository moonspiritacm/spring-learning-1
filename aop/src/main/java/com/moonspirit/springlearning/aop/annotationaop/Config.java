package com.moonspirit.springlearning.aop.annotationaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName      Config
 * @Description    配置类，使用注解 @Configuration 声明；
 *                 使用注解 @EnableAspectJAutoProxy 开启 AspectJ 自动代理；
 *                 使用注解 @ComponentScan("") 扫描指定包内所有注解，故本类内容为空。
 *
 * @author         moonspirit
 * @date           2018年7月18日    下午3:27:47
 * @version        1.0.0
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.moonspirit.springlearning.aop.annotationaop")
public class Config {

}
