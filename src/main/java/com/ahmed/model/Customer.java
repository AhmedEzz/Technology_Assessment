package com.ahmed.model;

import java.util.Date;

import com.ahmed.util.CustomerType;

public class Customer {

	private int id;
	private Date joinedDate;
	private CustomerType customerType;

	public Customer(int id, Date joinedDate, CustomerType customerType) {
		this.id = id;
		this.joinedDate = joinedDate;
		this.customerType = customerType;
	}

	public Customer(int id, Date joinDate) {
		this(id, joinDate, CustomerType.NORMAL);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

}
