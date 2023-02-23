package com.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.entity.RoleEntity;
import com.springboot.repository.IRoleRepository;
import com.springboot.service.IRoleService;
@Service
@Qualifier("RoleService")
public class RoleService implements IRoleService{
	@Autowired
	private IRoleRepository roleRepository;
	@Override
	public RoleEntity findOneByCode(String code) {
		return roleRepository.findOneByCode(code);
	}
}
