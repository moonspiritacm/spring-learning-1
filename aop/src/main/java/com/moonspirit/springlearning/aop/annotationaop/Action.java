package com.moonspirit.springlearning.aop.annotationaop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName      Action
 * @Description    根据拦截规则自定义注解，即元注解
 *                 @Retention(RetentionPolicy.RUNTIME) 定义注解保留规则为：注解在 class 字节码中存在，在运行时可以通过反射获取
 *                 @Target(ElementType.METHOD) 定义注解作用目标为方法
 *                 @Documented 定义注解被包含在 javadoc 中
 *
 * @author         moonspirit
 * @date           2018年7月18日    下午3:34:32
 * @version        1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

	String name();
}
