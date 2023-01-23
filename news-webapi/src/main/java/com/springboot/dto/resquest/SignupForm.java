package com.springboot.dto.resquest;

import java.util.List;

public class SignupForm {
	private String username;
	private String password;
	private String fullname;
	private Integer status;
	private List<String> roles;

	public SignupForm() {
	}

	public SignupForm(String username, String password, String fullname, Integer status, List<String> roles) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.status = status;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
