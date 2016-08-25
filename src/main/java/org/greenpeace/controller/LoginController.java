package org.greenpeace.controller;
 

import javax.faces.bean.ManagedBean; 

import org.greenpeace.utils.RandomText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Member;
import model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@ManagedBean(name = "loginCtrl")
public class LoginController {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	 
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
		LOGGER.debug("username: {}",user.getAccount());
		LOGGER.debug("password: {}" ,user.getPassword());
		
		
		LOGGER.debug("random : {}" ,new RandomText().generate());
		
		boolean userExist =userExist(user);
		
		if(userExist) {
			this.message = "" ;
			 return "success";
		} else {
			LOGGER.debug("帳號密碼錯誤，請重新登入");
			this.message = "帳號密碼錯誤，請重新登入" ;
			return null;
		}
	}
	
	
	
	
	/**
	 * User exist.
	 * 若使用者存在資料庫則驗證成功
	 * @param user the user
	 * @return true, if successful
	 */
	protected boolean userExist( User user ){
		UserDAO dao = new UserDAOImpl();
	 
		Member member = dao.getUserByAccount(user.getAccount(), user.getPassword());
		if(member != null) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Logout.
	 *
	 * @return the string
	 */
	public String logout() {
		LOGGER.debug("login!!");
		LOGGER.debug("username: {}",user.getAccount());
		LOGGER.debug("password: {}" ,user.getPassword());	
		return null;
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
	 * @param user the new user
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
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
