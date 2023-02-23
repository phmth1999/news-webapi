package com.springboot.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebAPI {
	
	@RequestMapping("/web")
	public String getWeb()
	{
		return "Hello Web";
	}
	
}
