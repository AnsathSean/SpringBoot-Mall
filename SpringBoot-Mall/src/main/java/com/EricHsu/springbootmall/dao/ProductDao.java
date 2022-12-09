package com.EricHsu.springbootmall.dao;
import java.util.List;

import com.EricHsu.springbootmall.constant.ProductCategory;
import com.EricHsu.springbootmall.dto.ProductQueryParams;
import com.EricHsu.springbootmall.dto.ProductRequest;
import com.EricHsu.springbootmall.model.Product;

public interface ProductDao {

	Product getProductById(Integer productId);



	Integer createProduct(ProductRequest productRequest);



	void updateProduct(Integer productId, ProductRequest productRequest);



	void deleteProductById(Integer productId);



	List<Product> getProducts(ProductQueryParams productQueryParams);



	Integer countProducts(ProductQueryParams productQueryParams);



}
