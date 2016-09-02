package org.greenpeace.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.greenpeace.bean.*;


import org.greenpeace.dao.*;

import org.greenpeace.service.Email02;
import org.greenpeace.utils.RandomPassword;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class LoginController.
 */
@ManagedBean(name = "test")
@SessionScoped
public class Login {
	
	

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(Login.class);

	/** The user. */
	private User user = new User();
	/** The message. */
	private String message;
	/**
	 * Login.
	 *
	 * @return the string
	 */
	public String login() {
		LOGGER.debug("login!!");
		LOGGER.debug("username: {}");
		LOGGER.debug("password: {}", user.getPassword());
		

		

		boolean userExist = userExist(user);
		FacesContext context = FacesContext.getCurrentInstance();
	    HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
//	    String checkCode  =(String ) session.getAttribute("check_code");
	    
//	    LOGGER.debug("checkCode : {}",checkCode);
	 
		if (userExist) {
			LOGGER.debug("成功");
			this.message = "";
			return "admin-services.xhtml";
		} else {
			LOGGER.debug("帳號密碼錯誤，請重新登入");
			this.message = "帳號密碼錯誤，請重新登入";
			return null;
		}
	}

	/**
	 * User exist. 若使用者存在資料庫則驗證成功
	 * 
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	protected boolean userExist(User user) {
		UserDAO dao = new UserDAOImpl();

		Member member = dao.getUserByAccount(user.getAccount(), user.getPassword());
		FacesContext context = FacesContext.getCurrentInstance();
	    HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("account",user.getAccount());
		if (member != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user
	 *            the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
