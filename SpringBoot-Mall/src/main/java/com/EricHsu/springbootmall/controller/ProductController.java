package com.EricHsu.springbootmall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EricHsu.springbootmall.dto.ProductRequest;
import com.EricHsu.springbootmall.model.Product;
import com.EricHsu.springbootmall.service.ProductServie;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServie productServie;
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
		Product product = productServie.getProductById(productId);
		if (product !=null) {
			return ResponseEntity.status(HttpStatus.OK).body(product);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
		
	}

	@PostMapping("/products/")
	public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest){
		Integer productId = productServie.createProduct(productRequest);
		Product product = productServie.getProductById(productId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
}
