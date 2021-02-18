package com.ratz.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ApplicationLoggerAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.ratz.pma.controllers..*)")
	public void definePackagePointcuts() {
		//empty just to name the location specified in the pointcut
	}
	
	@Around("definePackagePointcuts()")
	public Object logAround(ProceedingJoinPoint jp) {
		
		
		log.debug(" ---------------------------------Controllers in Work------------------------------------- ");
		log.debug("*************************************************************************\n \n {}.{} () with arguments[s] = {}", jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));

		log.debug("____________________________________________________________________________________________________ \n \n \n");
		
		Object o = null;
		try {
			o = jp.proceed();
		} catch (Throwable e) {

			e.printStackTrace();
		}
		
		
		log.debug("*************************************************************************\n \n {}.{} () with arguments[s] = {}", jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));

		log.debug("____________________________________________________________________________________________________ \n \n \n");
		
		return o;
		
	}
	
}
