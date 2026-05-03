package com.Ecommerce.EcommerceApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
