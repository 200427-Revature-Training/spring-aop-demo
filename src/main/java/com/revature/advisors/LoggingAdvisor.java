package com.revature.advisors;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvisor {

	Logger logger = Logger.getLogger(LoggingAdvisor.class);
	
	@Before("within(com.revature.services..*)")
	public void loggingAdvise(JoinPoint jp) {
		
		logger.info("Calling service method: " + jp.getSignature().getName() +
				" with args " + Arrays.toString(jp.getArgs()));
	}
}
