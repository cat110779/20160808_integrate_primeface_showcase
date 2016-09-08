package org.greenpeace.bean;

import java.io.Serializable;

public class ProductDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1980584198817754708L;

	private Product data;
	
	private int number;

	public ProductDto(Product data, int number) {
		super();
		this.data = data;
		this.number = number;
	}
	public ProductDto( ) {
		super(); 
	}
	public Product getData() {
		return data;
	}

	public void setData(Product data) {
		this.data = data;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
