package com.revature.advisors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnswerChangingAspect {
	
	
	@Pointcut("within(com.revature.services..*)")
	public void serviceTargeter() {}
	
	@Pointcut("execution(public double *(..))")
	public void doubleReturnTargeter() {}
	
	// Target the intersection of the above pointcuts such that it will target
	// only methods in the service layer which are public and return doubles
	@Around("serviceTargeter() && doubleReturnTargeter()")
	public double changeAnswer(ProceedingJoinPoint pjp) {
		try {
			Double response = (Double) pjp.proceed();
			return response - 1;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
