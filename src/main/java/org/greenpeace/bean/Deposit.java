package org.greenpeace.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;




/**
 * The persistent class for the DEPOSIT database table.
 * 
 */
@Entity
@NamedQuery(name="Deposit.findAll", query="SELECT d FROM Deposit d")
public class Deposit implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	private int id;

	@Column(name="DEPOSIT_CASH")
	private int depositCash;

	@Column(name="DEPOSIT_TIME")
	private Timestamp depositTime;

	@Column(name="member_account")
	private String memberAccount;
	
	//bi-directional many-to-one association to Member
	@Column(name="member_account")
	private Member member;

	public Deposit() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTime(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return df.format(depositTime);
	}
	
	public void setDepositTime(Timestamp depositTime) {
		this.depositTime = depositTime;
	}

	public Timestamp getDepositTime() {
		return depositTime;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getDepositCash() {
		return depositCash;
	}

	public void setDepositCash(int depositCash) {
		this.depositCash = depositCash;
	}

	
	public String getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}