package org.greenpeace.bean;

import java.util.Date;

public class OrderSuper {

	private int id;
	private int restaurant_id;
	private int member_id;
	private int money;
	private Date c_date;
	private String status; //訂單狀態
	private int order_id; //訂單編號
	private String order_member; //訂單發起人
	private String order_date; //下定日期
	private String product_name; // 產品名稱
	private String restaurant_name; //下定店家名稱
	private int l_money; // 餘額

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getL_money() {
		return l_money;
	}

	public void setL_money(int l_money) {
		this.l_money = l_money;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getOrder_member() {
		return order_member;
	}

	public void setOrder_member(String order_member) {
		this.order_member = order_member;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
}
