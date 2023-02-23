package com.springboot.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.response.JwtResponse;
import com.springboot.dto.response.ResponseMessage;
import com.springboot.dto.resquest.SigninForm;
import com.springboot.dto.resquest.SignupForm;
import com.springboot.entity.RoleEntity;
import com.springboot.entity.UserEntity;
import com.springboot.security.jwt.JwtProvider;
import com.springboot.security.userpincal.UserPrinciple;
import com.springboot.service.IRoleService;
import com.springboot.service.IUserService;
@CrossOrigin
@RestController
public class AuthAPI {
	@Autowired
	@Qualifier("UserService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("RoleService")
	private IRoleService roleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@PostMapping(value = "/auth/signup")
	public ResponseEntity<?> register(@RequestBody SignupForm signupForm){
		if(userService.existsByUsername(signupForm.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("The username exists!"), HttpStatus.OK);
		}
		UserEntity newUser = new UserEntity();
		newUser.setUserName(signupForm.getUsername());
		newUser.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		newUser.setFullname(signupForm.getFullname());
		newUser.setStatus(signupForm.getStatus());
		List<String> strRoles = signupForm.getRoles();
		List<RoleEntity> newRoles = new ArrayList<>();
		if(strRoles.size() < 0) {
			RoleEntity userRole = roleService.findOneByCode("ROLE_USER");
			if(userRole != null) {
				newRoles.add(userRole);
			}
		}else {
			strRoles.forEach(role -> {
				switch (role) {
				case "ROLE_ADMIN":
					RoleEntity adminRole = roleService.findOneByCode(role);
					if(adminRole != null) {
						newRoles.add(adminRole);
					}
					break;
				case "ROLE_STAFF":
					RoleEntity staffRole = roleService.findOneByCode(role);
					if(staffRole != null) {
						newRoles.add(staffRole);
					}
					break;
				case "ROLE_USER":
					RoleEntity userRole = roleService.findOneByCode(role);
					if(userRole != null) {
						newRoles.add(userRole);
					}
					break;
				}
			});
		}
		newUser.setRoles(newRoles);
		UserEntity userEntity = userService.save(newUser);
		return new ResponseEntity<>(new ResponseMessage("Create success!",userEntity), HttpStatus.OK);
	}
	@PostMapping(value = "/auth/signin")
	public ResponseEntity<?> login(@RequestBody SigninForm signinForm){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signinForm.getUsername(), signinForm.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtProvider.createToken(authentication);
		UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
		return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getFullname(), userPrinciple.getAuthorities()));
	}
}
