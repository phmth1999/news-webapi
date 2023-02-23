package com.springboot.service;

import java.util.List;

import com.springboot.entity.UserEntity;

public interface IUserService {
	List<UserEntity> findAll();
	UserEntity findOneByUsernameAndStatus(String username, Integer status);
	boolean existsByUsername(String username);
	UserEntity save(UserEntity userEntity);
}
