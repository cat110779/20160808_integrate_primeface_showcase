package org.greenpeace.controller;

import java.io.Serializable;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.greenpeace.bean.Order;
import org.greenpeace.bean.Product;
import org.greenpeace.bean.Restaurant;
import org.greenpeace.dao.OrderDAO;
import org.greenpeace.dao.ProductDAO;
import org.greenpeace.dao.RestaurantDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "omenu")
@RequestScoped
public class OrderMenuController implements Serializable {

	private static final long serialVersionUID = -5583905550715921385L;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderMenuController.class);
	private List<Order> allOrder = null;
    private List<Restaurant>allRest =null;
    private List<Product> pro =null;
    private int odcount;
	

	public String odermenu() {
		FacesContext context = FacesContext.getCurrentInstance();// session用
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);

		String account = (String) session.getAttribute("account");
		OrderDAO oDao = new OrderDAO();
		RestaurantDAO rDao = new RestaurantDAO();
		ProductDAO pDao =new ProductDAO();
		
		allOrder = oDao.getOrderByAccount(account);
		allRest = rDao.getAllRestaurant();
		
		 
		long now = System.currentTimeMillis();
		
		for (Order odmenu : allOrder) {
			if(odmenu.getStatus().equals("進行中")){
			
//			if(now-odmenu.getEndTime().getTime()>0||odmenu.getMoney()>=odmenu.getEndMoney()){
//				if(odmenu.getMoney()>0)
//					oDao.updateStatusByOrderId("已成立", odmenu.getId());
//				else
//					oDao.updateStatusByOrderId("已截止", odmenu.getId());								
//			}else if(odmenu.getMemberAccount().equals(account) && now-odmenu.getEndTime().getTime()<0 ){
//			
//			
//			}
			
			LOGGER.debug(Integer.toString(odmenu.getId()));
			LOGGER.debug(Integer.toString(odmenu.getRestaurantId()));
			LOGGER.debug(odmenu.getBeginTimeStr());
			LOGGER.debug(odmenu.getEndTimeStr());
			LOGGER.debug(Integer.toString(odmenu.getEndMoney()));
			LOGGER.debug(Integer.toString(odmenu.getMoney()));
		
			for(Restaurant rest: allRest){
				
				if(rest.getId()==odmenu.getRestaurantId()){
					LOGGER.debug(rest.getRType());
					LOGGER.debug(rest.getName());
					 pro = pDao.getProductByRestaurantId(odmenu.getRestaurantId());
					 for(Product product : pro){
							LOGGER.debug(product.getName());
							LOGGER.debug(Integer.toString(product.getPrice()));
							
							
							
							
					}
				}
				
			}
			
			
			}
			
		
		
		}
		return "addmenu.xhtml";

	}

	public List<Restaurant> getAllRest() {
		return allRest;
	}

	public void setAllRest(List<Restaurant> allRest) {
		this.allRest = allRest;
	}

	public List<Product> getPro() {
		return pro;
	}

	public void setPro(List<Product> pro) {
		this.pro = pro;
	}

	public List<Order> getAllOrder() {
		return allOrder;
	}

	public void setAllOrder(List<Order> allOrder) {
		this.allOrder = allOrder;
	}
	public int getOdcount() {
		return odcount;
	}

	public void setOdcount(int odcount) {
		this.odcount = odcount;
	}
}
