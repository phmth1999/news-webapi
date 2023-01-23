package com.springboot.service;

import com.springboot.entity.RoleEntity;

public interface IRoleService {
	RoleEntity findOneByCode(String code);
}
