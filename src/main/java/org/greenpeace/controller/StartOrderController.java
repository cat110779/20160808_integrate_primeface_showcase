package org.greenpeace.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.greenpeace.bean.Start;
import org.greenpeace.dao.RestaurantDAO;

@ManagedBean(name="storder")
@RequestScoped
public class StartOrderController implements Serializable{
private static final long serialVersionUID = 5416446903210588392L;

private List<Start> slist=null;

public String start(){
	FacesContext context = FacesContext.getCurrentInstance();// session用
    HttpSession session = (HttpSession) context.getExternalContext().getSession(true);	

   
    
	
	
	
	
	
	
	
	return null;
	
}

public List<Start> getSlist() {
	return slist;
}

public void setSlist(List<Start> slist) {
	this.slist = slist;
}
}
