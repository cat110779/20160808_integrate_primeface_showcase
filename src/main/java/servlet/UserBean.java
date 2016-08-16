package servlet;
import java.io.Serializable; 
import javax.faces.bean.ManagedBean; 
import javax.faces.bean.SessionScoped; 

@ManagedBean(name="user") 
@SessionScoped 
public class UserBean implements Serializable { 
private String name; 
private String password; 

public String getName() { 
return this.name; 
} 

public void setName(String nameString) { 
this.name = nameString; 
} 

public String getPassword() { 
return this.password; 
} 

public void setPassword(String passWordString) { 
this.password = passWordString; 
} 

}