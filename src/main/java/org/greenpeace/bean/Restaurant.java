package org.greenpeace.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RESTAURANT database table.
 * 
 */
@Entity
@NamedQuery(name="Restaurant.findAll", query="SELECT r FROM Restaurant r")
public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String addr;

	private String brief;

	private String name;

	private String phone;

	@Column(name="R_TYPE")
	private String rType;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="restaurant")
	private List<Product> products;

	public Restaurant() {
	}

	public int getId() {
		return this.id;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBrief() {
		if(this.brief!=null)
			return this.brief;
		else
			return "無";
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRType() {
		return this.rType;
	}

	public void setRType(String rType) {
		this.rType = rType;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setRestaurant(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setRestaurant(null);

		return product;
	}
	
	

}