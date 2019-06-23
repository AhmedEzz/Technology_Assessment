package com.ahmed.model;

import java.io.Serializable;
import java.util.Date;

import com.ahmed.util.CustomerType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date joinedDate;
	private CustomerType customerType;

	public Customer() {}
	
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
