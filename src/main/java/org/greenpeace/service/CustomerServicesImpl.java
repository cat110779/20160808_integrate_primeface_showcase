package org.greenpeace.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.greenpeace.bean.Customer;
import org.greenpeace.bean.CustomerDto;
import org.greenpeace.bean.ProductDto;
import org.greenpeace.dao.CustomerDAO;
import org.greenpeace.dao.ItemDAO;
import org.greenpeace.dao.OrderDAO;
import org.greenpeace.dao.ProductDAO;
import org.greenpeace.dao.RestaurantDAO;
import org.greenpeace.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerServicesImpl implements CustomerService {
	private Logger logger =LoggerFactory.getLogger(getClass());
	private CustomerDAO mainDao;
	private ItemDAO itemDao;
	private UserDAO userDao;
	private OrderDAO orderDao;
//	private ProductDAO productDao;
//	private RestaurantDAO restaurantDao;
//	private 

	@Override
	public boolean judgeExist(CustomerDto dto) {
		
		checkCustomer(dto.getPo());
		mainDao.createCustomer(dto.getPo());
		return false;
	}
	protected void checkPoExist(Customer data){
		String [] propeties =new String[]{"memberAccount" ,"item" ,"orderId"};
		for(String attr :propeties){
			try {
				Object value =PropertyUtils.getProperty(data, attr);
				 
				
			} catch (IllegalAccessException e) { 
				logger.debug(e.getMessage() ,e);
			} catch (InvocationTargetException e) {
				logger.debug(e.getMessage() ,e);
			} catch (NoSuchMethodException e) {
				logger.debug(e.getMessage() ,e);
			}
		}
	}
	protected void checkCustomer(Customer data){
		String [] propeties =new String[]{"memberAccount" ,"item" ,"orderId"};
		for(String attr :propeties){
			try {
				Object value =PropertyUtils.getProperty(data, attr);
				if(value ==null){
					throw new RuntimeException(attr + " 'value should not be null");
				}
			} catch (IllegalAccessException e) { 
				logger.debug(e.getMessage() ,e);
			} catch (InvocationTargetException e) {
				logger.debug(e.getMessage() ,e);
			} catch (NoSuchMethodException e) {
				logger.debug(e.getMessage() ,e);
			}
		}
	}
	
	@Override
	public CustomerDto logic(List<ProductDto> pro) {
		CustomerDto result =null;
		//TODO  還要判斷金額
		for(ProductDto unit : pro){
			if(unit.getNumber() > 0){
				logger.debug("product namr: {}",unit.getData().getName());
				if( result ==null ){
					result =new CustomerDto();
					result.setOk(true);
				}
			}
		}
		
		return result;
	}

}
