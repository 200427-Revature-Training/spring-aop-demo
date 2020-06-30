package com.revature.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.MathService;

@RestController
@RequestMapping("/math")
public class MathController {
	Logger logger = Logger.getLogger(MathController.class);
	
	@Autowired
	MathService mathService;
	
	// GET /math/add?a=10&b=20
	@GetMapping("/add")
	public MathResponse addValues(@RequestParam(required=true) int a, 
									@RequestParam(required=true) int b) {
		logger.info("In controller handler");
		return new MathResponse(mathService.addValues(a,  b));
	}

}

class MathResponse {
	private double result;

	public MathResponse(double result) {
		super();
		this.result = result;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public MathResponse() {
		super();
	}
	
}
