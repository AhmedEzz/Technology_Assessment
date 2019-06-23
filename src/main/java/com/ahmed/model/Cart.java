package com.ahmed.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Set<Item> items;
	private Customer customer;
	
	public Cart(Customer customer) {
		this.customer = customer;
		this.items = new LinkedHashSet<>();
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public void addItem(Item item) {
		item.setId(UUID.randomUUID().variant());
		items.add(item);
	}
	
}
