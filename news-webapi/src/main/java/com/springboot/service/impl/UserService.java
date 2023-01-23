package com.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.UserEntity;
import com.springboot.repository.IUserRepository;
import com.springboot.service.IUserService;
@Service
public class UserService implements IUserService{
	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserEntity findOneByUsernameAndStatus(String username, Integer status) {
		return userRepository.findOneByUsernameAndStatus(username, status);
	}

	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public UserEntity save(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}
	

}
