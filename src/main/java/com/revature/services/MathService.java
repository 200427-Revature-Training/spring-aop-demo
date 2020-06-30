package com.revature.services;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class MathService {

	Logger logger = Logger.getLogger(MathService.class);
	
	
	public double addValues(int a, int b) {
		logger.info("In service method");
		return a + b;
	}
	
}
