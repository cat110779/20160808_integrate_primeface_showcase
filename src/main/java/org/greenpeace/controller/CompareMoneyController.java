package org.greenpeace.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.greenpeace.bean.Customer;
import org.greenpeace.bean.CustomerDto;
import org.greenpeace.bean.ProductDto;
import org.greenpeace.service.CustomerService;
import org.greenpeace.service.CustomerServicesImpl;

@ManagedBean(name = "cpmoney")
@RequestScoped
public class CompareMoneyController implements Serializable {
	private static final long serialVersionUID = 1715137869469866421L;
	private CustomerDto data;
	private CustomerService service = new CustomerServicesImpl();
	@PostConstruct
	protected void postMethod(){
		data =new CustomerDto();
		data.setPo(new Customer());
	}
	public String compareMoney(List<ProductDto> pro) {
		// 會員餘額是否大於結帳金額
		CustomerDto tmp  = service.logic( pro);
		 
		if (tmp.isOk()) {
			return compareStatus(data);
		} else {
			return "failure";
		}
	}

	public String compareStatus(CustomerDto data) {
		String result = "orderStillExist";

		// 結帳金額是否大於結標金額
		boolean ok = service.judgeExist(data);
		
		if(!ok){
			result="訂單消失";
		}
		return result;
	}

	public CustomerDto getData() {
		return data;
	}

	public void setData(CustomerDto data) {
		this.data = data;
	}

	public void setService(CustomerService service) {
		this.service = service;
	}
	
}
