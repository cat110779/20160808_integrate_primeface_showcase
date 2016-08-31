package org.greenpeace.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	// bi-directional many-to-one association to Customer
	@OneToMany(mappedBy = "item")
	private List<Customer> customers;

	// bi-directional many-to-one association to Order

	private Order order;


	// bi-directional many-to-one association to Product
	@ManyToOne
	private Product 
	product;

	private int productId;

	private String productName;

	private int orderId;
	
	

	public Item() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setItem(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setItem(null);

		return customer;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
		orderId = order.getId();
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
		productId = product.getId();
		productName = product.getName();
	}
	
	public void setProduct(String name,int price) {
		this.product = new Product();
		this.product.setName(name);
		this.product.setPrice(price);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
		this.product.setId(productId);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	
}