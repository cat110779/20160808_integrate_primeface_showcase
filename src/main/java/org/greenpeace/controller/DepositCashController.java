package org.greenpeace.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.accessibility.AccessibleRelation;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.search.IntegerComparisonTerm;
import javax.servlet.http.HttpSession;

import org.greenpeace.bean.Deposit;
import org.greenpeace.dao.DepositDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@ManagedBean(name = "depositcash")
@SessionScoped
public class DepositCashController implements Serializable{
private static final long serialVersionUID = -8501692478792876840L;	
private static final Logger LOGGER = LoggerFactory.getLogger(DepositCashController.class);


private List<Deposit>rlist=null;//叫到前端

public String depoist(){
	FacesContext context = FacesContext.getCurrentInstance();//session用
	HttpSession session = (HttpSession) context.getExternalContext().getSession(true);	
    String account = (String) session.getAttribute("account");//找要用的session
    DepositDAO  dao = new DepositDAO();//簡
   rlist = dao.queryByMemberAccount(account);
	
	for(Deposit deposit : rlist){
		SimpleDateFormat test = new SimpleDateFormat("yyyy/MM/dd ");

		LOGGER.debug(Integer.toString(deposit.getId()));
		LOGGER.debug(Integer.toString(deposit.getDepositCash()));
		LOGGER.debug(test.format(deposit.getDepositTime()));
		
		
		
		
	}
	
	
	return null;
	
	
	
	



}


	
	
	
	
	

public List<Deposit> getRlist() {
	return rlist;
}
public void setRlist(List<Deposit> rlist) {
	this.rlist = rlist;
}}