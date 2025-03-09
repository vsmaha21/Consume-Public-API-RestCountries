package com.rest.countries.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	Logger log = Logger.getLogger("LoggingAspect");

	@Before("execution(* com.rest.countries.service.*.* (..))")
	public void logBefore(JoinPoint joinPoint) {

		log.info("Logging before execution of method: " + joinPoint.getSignature().getName());
	}

	@AfterThrowing("execution(* com.rest.countries.service.*.* (..))")
	public void logAfterThrowing(JoinPoint joinPoint) {

		log.info("Error is thrown by method: " + joinPoint.getSignature().getName());

	}

	@AfterReturning("execution(* com.rest.countries.service.*.* (..))")
	public void logAfterReturning(JoinPoint joinPoint) {
		log.info("Logging after successful execution of method: " + joinPoint.getSignature().getName());

	}

}
