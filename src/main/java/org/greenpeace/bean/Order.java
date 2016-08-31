package org.greenpeace.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name="ORDERS")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="BEGIN_TIME")
	private Timestamp beginTime;

	@Column(name="END_MONEY")
	private int endMoney;

	@Column(name="END_TIME")
	private Timestamp endTime;

	
	
	@Column(name="RESTAURANT_ID")
	private Restaurant restaurant;
	
	private String rtype;

	@Column(name="RESTAURANT_ID")
	private int restaurantId;
	
	@Column(name="RESTAURANT_ID")
	private String restaurantName;
	
	@Column(name="RESTAURANT_ID")
	private String restaurantPhone;
	
	@Column(name="Member_Account")
	private int money;
	
	@Column(name="Member_Account")
    private String memberAccount;
	
	private String info;
	
	private String status;
	

	//bi-directional many-to-one association to Item
	private List<Item> items;

	//bi-directional many-to-one association to Member
	
	@Column(name="Member_Account")
	private Member member;


	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
		restaurantId = restaurant.getId();
		restaurantName = restaurant.getName();
	}

	public String getInfo() {
		if(info==null)
			return "";
		else
			return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	public String getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}

	public Order() {
		
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBeginTime(){
		this.beginTime = new Timestamp(System.currentTimeMillis());
	}
	
	public void setBeginTime(Timestamp ts){
		this.beginTime = ts;
	}
	
	public Timestamp getBeginTime() {
		return this.beginTime;
	}
	
	public String getBeginTimeStr(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return df.format(beginTime);
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}
	
	public String getEndTimeStr(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return df.format(endTime);
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public int getEndMoney() {
		return endMoney;
	}

	public void setEndMoney(int endMoney) {
		this.endMoney = endMoney;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setOrder(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setOrder(null);

		return item;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
		this.memberAccount = member.getAccount();
	}

	public String getRestaurantPhone() {
		return restaurantPhone;
	}

	public void setRestaurantPhone(String restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}

	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	
	
	
}