package org.greenpeace.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.greenpeace.bean.Order;
import org.greenpeace.dao.CustomerDAO;
import org.greenpeace.dao.OrderDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@ManagedBean(name="depositstatus")
@SessionScoped
public class DepositStatusController implements Serializable{

	private static final long serialVersionUID = -4004412259724803223L;
	private static final Logger LOGGER = LoggerFactory.getLogger(DepositStatusController.class);
	
	private List<Order> status=null;
public String dstatus(){
	FacesContext context = FacesContext.getCurrentInstance();//session用
	HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	String account = (String) session.getAttribute("account");
	OrderDAO dao =new OrderDAO();
	
   status =dao.getOrderByAccount(account);
  
   for(Order order :status){
	   SimpleDateFormat test = new SimpleDateFormat("yyyy/MM/dd ");
   
	   LOGGER.debug(Integer.toString(order.getId()));
	   LOGGER.debug(test.format(order.getBeginTime()));
	   LOGGER.debug(order.getRestaurantName());
	   LOGGER.debug(order.getStatus());
	   LOGGER.debug(order.getMemberAccount());
	   
	   
	   
   }
	return null;
	
		
}
	public List<Order> getStatus() {
		return status;
	}


	public void setStatus(List<Order> status) {
		this.status = status;
	}
	
}
