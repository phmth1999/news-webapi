package com.springboot.dto.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
	private String type ="Bearer";
	private String token;
	private String fullName;
	private Collection<? extends GrantedAuthority> roles;

	public JwtResponse(String type, String token, String fullName,
			Collection<? extends GrantedAuthority> roles) {
		this.type = type;
		this.token = token;
		this.fullName = fullName;
		this.roles = roles;
	}
	public JwtResponse(String token, String fullName,
			Collection<? extends GrantedAuthority> roles) {
		this.token = token;
		this.fullName = fullName;
		this.roles = roles;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}

	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}

}
