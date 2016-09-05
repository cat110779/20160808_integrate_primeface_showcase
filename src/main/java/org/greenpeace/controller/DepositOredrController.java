package org.greenpeace.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.greenpeace.bean.CustomerSuper;
import org.greenpeace.dao.CustomerDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@ManagedBean(name="depositorder")
@SessionScoped
public class DepositOredrController implements Serializable{
private static final long serialVersionUID = 8188293819809380080L;

private static final Logger LOGGER = LoggerFactory.getLogger(DepositCashController.class);

private List<CustomerSuper> osuper;
public String dosuper(){
	FacesContext context = FacesContext.getCurrentInstance();//session用
	HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	String account = (String) session.getAttribute("account");	
	CustomerDAO dao =new CustomerDAO();
	osuper =dao.queryCustomerList(account);
	
	for(CustomerSuper depositc :osuper){
		SimpleDateFormat test = new SimpleDateFormat("yyyy/MM/dd HH:mm ");
		
        LOGGER.debug(Integer.toString(depositc.getId()));
		LOGGER.debug(depositc.getProduct_name());
		LOGGER.debug(Integer.toString(depositc.getCounts()));
		LOGGER.debug(Integer.toString(depositc.getMoney()));
		LOGGER.debug(depositc.getConsume_date());
	}
	return null;
}
public List<CustomerSuper> getOsuper() {
	return osuper;
}
public void setOsuper(List<CustomerSuper> osuper) {
	this.osuper = osuper;
}
}