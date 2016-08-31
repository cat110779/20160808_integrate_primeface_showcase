package org.greenpeace.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	@Column(name="order_id")
	private int orderId;
	
	
	
	@Column(name="member_account")
	private String memberAccount;
	
	@Column(name="C_DATE")
	private Timestamp cDate;
	
	private int counts;
	@Column(name="\"MONEY\"")
	
	private int money;
	private String status;
	//bi-directional many-to-one association to Item
	
	@Column(name="item_Id")
	private Item item;
	//bi-directional many-to-one association to Member
	
	@Column(name="member_account")
	private Member member;
	
	@Column(name="item_id")
	private String itemName;
	
	@Column(name="item_id")
	private int itemPrice;
	
	public Customer() {
	}
	

	public Timestamp getCDate() {
		return this.cDate;
	}
	

	public void setCDate(Timestamp cDate) {
		this.cDate = cDate;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getMemberAccount() {
		return memberAccount;
	}


	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	


}