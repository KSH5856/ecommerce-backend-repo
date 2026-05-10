package com.Ecommerce.EcommerceApplication.controller;

import com.Ecommerce.EcommerceApplication.dto.request.ProductDetailsRequest;
import com.Ecommerce.EcommerceApplication.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.EcommerceApplication.service.EcommerceService;

@RestController
public class EcommerceController {

	@Autowired
	private EcommerceService productService;

	@GetMapping("productList")
	public ResponseEntity<Object> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping("addProduct")
	public ResponseEntity<Object> addProducts(@RequestBody ProductDetailsRequest product){
		return productService.addProduct(product);
	}
	

}
