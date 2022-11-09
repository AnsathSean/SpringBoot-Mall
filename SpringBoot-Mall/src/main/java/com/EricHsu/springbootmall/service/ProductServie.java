package com.EricHsu.springbootmall.service;
import java.util.List;

import com.EricHsu.springbootmall.dto.ProductRequest;
import com.EricHsu.springbootmall.model.Product;

public interface ProductServie {
	Product getProductById(Integer productId);
	
	Integer createProduct(ProductRequest productRequest);

	void updateProduct(Integer productId, ProductRequest productRequest);

	void deleteProductById(Integer productId);

	List<Product> getProducts();
}
