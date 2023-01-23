package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.UserEntity;
@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
	UserEntity findOneByUsernameAndStatus(String username, int status);
	
	UserEntity findOneByUsername(String username);
	
	Boolean existsByUsername(String username);


}
