package org.greenpeace.service;

import java.util.List;

import org.greenpeace.bean.CustomerDto;
import org.greenpeace.bean.ProductDto;

public interface CustomerService {

	CustomerDto logic(List<ProductDto> pro);

	boolean judgeExist(CustomerDto data);

}
