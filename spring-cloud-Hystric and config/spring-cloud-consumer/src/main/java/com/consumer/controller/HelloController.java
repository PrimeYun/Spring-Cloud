package com.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${neo.config}")
	private String port;
	
	@RequestMapping("/hello")
	public String hello() {
		return this.port;
	}
	
}
