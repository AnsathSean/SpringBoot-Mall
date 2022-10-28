package com.EricHsu.springbootmall.dto;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;
import org.springframework.lang.NonNull;

import com.EricHsu.springbootmall.constant.ProductCategory;

public class ProductRequest {

	@NonNull
	private String productName;
	@NonNull
	private ProductCategory category;
	@NonNull
	private String imageUrl;
	@NonNull
	private Integer price;
	@NonNull
	private Integer stock;
	@Nullable
	private String description;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
