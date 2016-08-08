package model;

import java.util.Date;

public class User {
 //設定資料型態
 private int id;
 private String account;
 private String password;
 private String email;
 private int cash;
 private Date create_date;
 private String m_type;
 
 public User(){
  
 }
 
 public User(String account, String email, String password) {
  this.account = account;
  this.email = email;
  this.password = password;
 }
 
 
 public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 public String getAccount() {
  return account;
 }
 public void setAccount(String account) {
  this.account = account;
 }
 public String getEmail() {
  return email;
 }
 public void setEmail(String email) {
  this.email = email;
 }
 public String getPassword() {
  return password;
 }
 public void setPassword(String password) {
  this.password = password;
 }
 
public int getCash() {
	return cash;
}

public void setCash(int cash) {
	this.cash = cash;
}

public Date getCreate_date() {
	return create_date;
}

public void setCreate_date(Date create_date) {
	this.create_date = create_date;
}

public String getM_type() {
	return m_type;
}

public void setM_type(String m_type) {
	this.m_type = m_type;
}

//重寫父類的方法，在方法前面加上@Override 系統可以幫你檢查方法的正確性
 @Override
 //改寫java.lang.Object傳回一個代表該物件的字串. 如果該類別沒有 override
 //則 toString() 的原本功能將是傳回一個字串,內容是 :該物件所屬類別名稱 + @ + 該物件 hash code 的16進位值
 public String toString() {     
	 return "User [id=" + id + ", account=" + account + ", password=" + password + "]";
 }
 
 
 
}