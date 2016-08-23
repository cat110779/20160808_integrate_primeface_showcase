package org.greenpeace.controller;

import javax.faces.bean.ManagedBean; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "loginCtrl")
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	private String username;
	private String password ;

	
	public String login() {
		LOGGER.debug("login!!");
		LOGGER.debug("username: {}",username);
		LOGGER.debug("password: {}" ,password);		
		return "success";
	}
	public void logout() {
		LOGGER.debug("login!!");
		LOGGER.debug("username: {}",username);
		LOGGER.debug("password: {}" ,password);
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
	
}
