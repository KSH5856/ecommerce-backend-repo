package com.Ecommerce.EcommerceApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Ecommerce.EcommerceApplication.entity.ProductDetails;
import com.Ecommerce.EcommerceApplication.repository.ProductRepository;

@Service
public class EcommerceService {

	@Autowired
	private ProductRepository productRepo;

	public ResponseEntity<Object> getAllProducts() {

		List<ProductDetails> productList = productRepo.findAll();
		return new ResponseEntity(productList, HttpStatus.OK);
	}
}
