package com.EricHsu.springbootmall.dao;
import com.EricHsu.springbootmall.model.Product;

public interface ProductDao {

	Product getProductById(Integer productId);
}
