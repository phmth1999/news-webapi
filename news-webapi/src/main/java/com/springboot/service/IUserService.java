package com.springboot.service;

import com.springboot.entity.UserEntity;

public interface IUserService {
	UserEntity findOneByUsernameAndStatus(String username, Integer status);
	boolean existsByUsername(String username);
	UserEntity save(UserEntity userEntity);
}
