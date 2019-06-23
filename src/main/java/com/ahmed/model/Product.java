package com.ahmed.model;

import java.io.Serializable;

import com.ahmed.util.ProductType;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private double price;
	private ProductType productType;

	public Product(int id, double price, ProductType productType) {
		this.id = id;
		this.price = price;
		this.productType = productType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}

}
