package com.rest.countries.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

	Logger log = Logger.getLogger("PerformanceAspect");

	@Around("execution(* com.rest.countries.controller.*.* (..))")
	public Object monitorPerformanceTime(ProceedingJoinPoint jp) throws Throwable {
		Long startTime = System.currentTimeMillis();

		Object obj = jp.proceed();
		long endTime = System.currentTimeMillis();

		log.info("Time taken by request: " + jp.getSignature().getName() + " " + (endTime - startTime) + " ms");
		return obj;
	}

}
