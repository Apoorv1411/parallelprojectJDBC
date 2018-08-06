package com.cg.account.bean;

import java.sql.Date;

public class Account {
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getmobileNo() {
		return mobileNo;
	}
	public void setmobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	private String name;
	private String mobileNo; 
	private String email;
    private double balance;
    Date date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Account(String name, String mobileNo, String email, double balance,
			Date date) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.balance = balance;
		this.date = date;
	}
	public Account() {
		super();
		
	}
}	
		
	
	
	
	

