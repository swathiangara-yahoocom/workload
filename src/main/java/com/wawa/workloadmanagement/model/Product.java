package com.wawa.workloadmanagement.model;

public class Product {
	Integer productId;
	String productName;
	Double price;
	ProductGroup productGrop;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public ProductGroup getProductGroup() {
		return productGrop;
	}
	public void setProductGropId(ProductGroup productGropId) {
		this.productGropId = productGropId;
	}
	
	
}
