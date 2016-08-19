package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.Member;
import model.User;

@ManagedBean(name = "testBean")
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user = new User();
	private String message;
  private String validateUsernamePassword;
  
	public String getValidateUsernamePassword() {
	return validateUsernamePassword;
}

public void setValidateUsernamePassword(String validateUsernamePassword) {
	this.validateUsernamePassword = validateUsernamePassword;
}

	public String validateUsernamePassword() {
		
		System.out.println("帳號 : " + user.getAccount());
		System.out.println("密碼 : " + user.getPassword());
		
		UserDAO dao = new UserDAOImpl();
		
		Member member = dao.getUserByAccount(user.getAccount(), user.getPassword());
		
		if(member != null) {
			setMessage("");
			return "admin-service2";
		} else {
			setMessage("帳號密碼錯誤，請重新登入");
			return "index2";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
