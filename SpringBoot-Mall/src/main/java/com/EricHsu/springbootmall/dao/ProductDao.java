package com.EricHsu.springbootmall.dao;
import com.EricHsu.springbootmall.dto.ProductRequest;
import com.EricHsu.springbootmall.model.Product;

public interface ProductDao {

	Product getProductById(Integer productId);



	Integer createProduct(ProductRequest productRequest);



	void updateProduct(Integer productId, ProductRequest productRequest);



}
