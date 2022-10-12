package com.EricHsu.springbootmall.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.EricHsu.springbootmall.dao.ProductDao;
import com.EricHsu.springbootmall.model.Product;
import com.EricHsu.springbootmall.service.ProductServie;


@Component
public class ProdcutServiceImpl implements ProductServie{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product getProductById(Integer productId) {
		return productDao.getProductById(productId);
	}
}
