package com.moonspirit.springlearning.aop.annotationaop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @ClassName      AnnotationAspect
 * @Description    AnnotationService 切面类
 *
 * @author         moonspirit
 * @date           2018年7月19日    上午10:47:40
 * @version        1.0.0
 */
@Aspect
@Component
public class AnnotationAspect {

	/**
	 * @MethodName       annotationPointCut
	 * @Description      定义切点，相当于连接点的查询条件
	 *
	 * @param            
	 * @return           void
	 * @throws
	 */
	@Pointcut("@annotation(Action)")
	public void annotationPointCut() {
	};

	/**
	 * @MethodName       before
	 * @Description      前置通知
	 *
	 * @param            joinPoint
	 * @return           void
	 * @throws
	 */
	@Before("annotationPointCut()")
	public void before(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("注解式拦截，前置通知：" + action.name());
	}

	/**
	 * @MethodName       after
	 * @Description      后置通知
	 *
	 * @param            joinPoint
	 * @return           void
	 * @throws
	 */
	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("注解式拦截，后置通知：" + action.name());
	}

	/**
	 * @MethodName       afterRetruning
	 * @Description      返回后通知
	 *
	 * @param            joinPoint
	 * @return           void
	 * @throws
	 */
	@AfterReturning("annotationPointCut()")
	public void afterRetruning(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("注解式拦截，返回后通知：" + action.name());
	}
}
