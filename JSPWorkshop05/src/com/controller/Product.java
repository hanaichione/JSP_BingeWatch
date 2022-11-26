package com.controller;

public class Product {
	String productName;
	String productId;
	int productAmount;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String productName, String productId, int productAmount) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.productAmount = productAmount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
}
