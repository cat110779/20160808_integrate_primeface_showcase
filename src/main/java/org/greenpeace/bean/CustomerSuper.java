package org.greenpeace.bean;


import java.util.Date;

public class CustomerSuper {
	
	
	private int id;
	private int item_id;
	private int member_id;
	private int counts;
	private int money;
	private Date c_date;
	private String status;
	private String consume_date; //消費日期
	private String product_name; //產品名稱
	private int l_money; //餘額
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
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
	public String getConsume_date() {
		return consume_date;
	}
	
	public void setConsume_date(String consume_date) {
		this.consume_date = consume_date;
	}
}
