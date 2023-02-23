package com.springboot.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminAPI {
	
	@RequestMapping("/admin")
	public String getAdmin()
	{
		return "Hello Admin";
	}

}
