package com.gdufe.osc.interceptor;

import com.gdufe.osc.annotation.TimeWatch;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author: yizhen
 * @date: 2019/1/24 15:38
 */
@Component
@Slf4j
@Aspect
public class TimeWatchAspect {

	@Pointcut("execution(public * com.gdufe.osc.controller..*(..))")
	public void pointcutController() {}

	@Pointcut("@annotation(com.gdufe.osc.annotation.TimeWatch)")
	public void pointcutTimeWatch() {}

	@Around(value = "pointcutController() && pointcutTimeWatch()")
	public Object methodAround(ProceedingJoinPoint joinPoint) {
		Object res = null;
		String methodName = joinPoint.getSignature().getName();
		try {
			// 前置通知
			Stopwatch stopwatch = Stopwatch.createStarted();
			// 执行目标方法
			res = joinPoint.proceed();
			// 后置通知
			long duration = stopwatch.elapsed(TimeUnit.MILLISECONDS);
			log.info("{} 执行时长: {}ms", methodName, duration);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		//a(joinPoint);
		return res;
	}

	// 获取注解的值
	private void a(ProceedingJoinPoint joinPoint) {
		MethodSignature ms = (MethodSignature) joinPoint.getSignature();
		Class clazz = joinPoint.getTarget().getClass();
		try {
			Method method = clazz.getMethod(ms.getName(), ms.getParameterTypes());
			TimeWatch tw = method.getAnnotation(TimeWatch.class);
			System.out.println(tw);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
















