package com.moonspirit.springlearning.aop.methodaop;

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
 * @ClassName      MethodAspect
 * @Description    MethodService 切面类
 *
 * @author         moonspirit
 * @date           2018年7月19日    上午10:47:40
 * @version        1.0.0
 */
@Aspect
@Component
public class MethodAspect {

	/**
	 * @MethodName       methodPointCut
	 * @Description      定义切点，相当于连接点的查询条件
	 *
	 * @param            
	 * @return           void
	 * @throws
	 */
	@Pointcut("execution(* MethodService.*(..))")
	public void methodPointCut() {
	};

	/**
	 * @MethodName       before
	 * @Description      前置通知
	 *
	 * @param            joinPoint
	 * @return           void
	 * @throws
	 */
	@Before("methodPointCut()")
	public void before(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则拦截，前置通知：" + method.getName());
	}

	/**
	 * @MethodName       after
	 * @Description      后置通知
	 *
	 * @param            joinPoint
	 * @return           void
	 * @throws
	 */
	@After("methodPointCut()")
	public void after(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则拦截，后置通知：" + method.getName());
	}

	/**
	 * @MethodName       afterRetruning
	 * @Description      返回后通知
	 *
	 * @param            joinPoint
	 * @return           void
	 * @throws
	 */
	@AfterReturning("methodPointCut()")
	public void afterRetruning(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则拦截，返回后通知：" + method.getName());
	}
}
