package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.RoleEntity;
@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findOneByCode(String code);
	
}
