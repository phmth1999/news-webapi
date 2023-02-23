package com.springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.response.ResponseMessage;
import com.springboot.entity.UserEntity;
import com.springboot.service.IUserService;

@RestController
public class UserAPI {
	@Autowired
	@Qualifier("UserService")
	private IUserService userService;
	
	@RequestMapping("/user")
	public ResponseEntity<?> getUser(){
		List<UserEntity> listUser = userService.findAll();
		return new ResponseEntity<>(new ResponseMessage("success!",listUser), HttpStatus.OK);
	}
	
}
