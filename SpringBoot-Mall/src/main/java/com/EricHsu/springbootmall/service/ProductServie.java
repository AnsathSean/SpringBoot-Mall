package com.EricHsu.springbootmall.service;
import com.EricHsu.springbootmall.dto.ProductRequest;
import com.EricHsu.springbootmall.model.Product;

public interface ProductServie {
	Product getProductById(Integer productId);
	
	Integer createProduct(ProductRequest productRequest);
}
