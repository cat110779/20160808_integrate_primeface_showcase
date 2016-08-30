package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.greenpeace.utils.RandomPassword;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Member;
import model.User;
import service.Email02;

/**
 * The Class LoginController.
 */
@ManagedBean(name = "test")
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
		
		System.out.println(user.getPassword());
		System.out.println(user.getAccount());

		

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
