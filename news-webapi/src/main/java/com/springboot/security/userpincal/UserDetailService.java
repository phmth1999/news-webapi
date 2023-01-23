package com.springboot.security.userpincal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.entity.RoleEntity;
import com.springboot.entity.UserEntity;
import com.springboot.repository.IUserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserPrinciple userPrinciple = null;
		UserEntity userEntity = userRepository.findOneByUsernameAndStatus(username, 1);
		try {
			if (userEntity == null) {
				throw new UsernameNotFoundException("User not found");
			}
			List<GrantedAuthority> authorities = new ArrayList<>();
			for (RoleEntity role : userEntity.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.getCode()));
			}
			userPrinciple = new UserPrinciple(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword(),
					userEntity.getFullname(), userEntity.getStatus(), authorities);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userPrinciple;
	}
}
