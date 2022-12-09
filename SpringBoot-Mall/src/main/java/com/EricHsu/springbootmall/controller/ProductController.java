package com.EricHsu.springbootmall.controller;


import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EricHsu.springbootmall.constant.ProductCategory;
import com.EricHsu.springbootmall.dto.ProductQueryParams;
import com.EricHsu.springbootmall.dto.ProductRequest;
import com.EricHsu.springbootmall.model.Product;
import com.EricHsu.springbootmall.service.ProductServie;
import com.EricHsu.springbootmall.util.Page;

@Validated
@RestController
public class ProductController {
	
	@Autowired
	private ProductServie productServie;
	//取得商品清單
	@GetMapping("/products")
	public ResponseEntity<Page<Product>> getProducts(
			//查詢條件 Filtering
			@RequestParam(required = false) ProductCategory category,
			@RequestParam(required = false) String search,
			
			//排序 Sorting
			@RequestParam(defaultValue = "created_date") String orderBy,
			@RequestParam(defaultValue = "desc") String sort,
			
			//分頁 Pagenation
			@RequestParam(defaultValue = "5")  @Max(1000) @Min(0) Integer limit,
			@RequestParam(defaultValue = "0") @Min(0) Integer offset
	){
		ProductQueryParams productQueryParams = new ProductQueryParams();
		productQueryParams.setCategory(category);
		productQueryParams.setSearch(search);
		productQueryParams.setOrderBy(orderBy);
		productQueryParams.setSort(sort);
		productQueryParams.setLimit(limit);
		productQueryParams.setOffset(offset);
		
		//取得Product List
		List<Product> proudctList = productServie.getProducts(productQueryParams);
		Integer total = productServie.countProducts(productQueryParams);
		
		Page<Product> page = new Page<>();
		page.setLimit(limit);
		page.setOffset(offset);
		page.setTotal(total);
		page.setResults(proudctList);
		
		return ResponseEntity.status(HttpStatus.OK).body(page);
		
		
	}
	//藉由ID查詢商品
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> Product(@PathVariable Integer productId){
		Product product = productServie.getProductById(productId);
		if (product !=null) {
			return ResponseEntity.status(HttpStatus.OK).body(product);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
		
	}
	//新增商品
	@PostMapping("/products/")
	public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest){
		Integer productId = productServie.createProduct(productRequest);
		Product product = productServie.getProductById(productId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	//修改商品
	@PutMapping("/products/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
												@RequestBody ProductRequest productRequest){
		Product product = productServie.getProductById(productId);
		
		if (product ==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		productServie.updateProduct(productId, productRequest);
		
		Product updateProduct = productServie.getProductById(productId);
		return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
		
	}
	//刪除商品
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Product> deleteProudct(@PathVariable Integer productId){
	
		productServie.deleteProductById(productId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
