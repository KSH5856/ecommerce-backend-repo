package com.Ecommerce.EcommerceApplication.service;

import java.util.List;

import com.Ecommerce.EcommerceApplication.dto.request.ProductDetailsRequest;
import com.Ecommerce.EcommerceApplication.dto.response.SuccessResponse;
import com.Ecommerce.EcommerceApplication.mapper.DTOMapper;
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
		
		SuccessResponse<List<ProductDetails>> response = new SuccessResponse<>();
		response.setError(false);
		response.setResponse(productList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	public ResponseEntity<Object> addProduct(ProductDetailsRequest product) {
		ProductDetails newProduct = DTOMapper.BuildProductRequest(product);
		productRepo.save(newProduct);
		
		SuccessResponse response = new SuccessResponse();
		response.setError(false);
		response.setResponse("Product added successfully");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}

