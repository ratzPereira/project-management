package com.ratz.pma.logging;

import org.aspectj.lang.annotation.After;
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
	
	@Pointcut("within(com.ratz.pma.controllers..*)"+ "|| within(com.ratz.pma.dto..*)")
	public void definePackagePointcuts() {
		//empty just to name the location specified in the pointcut
	}
	
	@Before("definePackagePointcuts()")
	public void log() {
		log.debug(" ---------------------------------Controllers in Work------------------------------------- ");
	}
	
}
