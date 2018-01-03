package com.fdmgroup.issuetracker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Component;

public class BeforeAdvice {
	
	static Logger myLogger = Logger.getLogger("myLogger");
	static {
		PropertyConfigurator.configure("./src/main/resources/META-INF/log4j.properties");
	}
	
	private boolean beforeCalled = false;
	
	public void reset() {
		beforeCalled = false;
	}
	
	public boolean isBeforeCalled() {
	    return beforeCalled;
	  }

	  @Before("execution(* *(..))")
	  public void entering(JoinPoint joinPoint) {
	    beforeCalled = true;
	    myLogger.trace("entering "
	        + joinPoint.getStaticPart().getSignature().toString());
	  }

}
