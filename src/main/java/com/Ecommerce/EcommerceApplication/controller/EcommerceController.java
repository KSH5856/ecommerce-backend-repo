package com.Ecommerce.EcommerceApplication.controller;

import com.Ecommerce.EcommerceApplication.dto.request.ProductListByCategoryRequest;
import com.Ecommerce.EcommerceApplication.dto.response.CategoryCountMappingResponse;
import com.Ecommerce.EcommerceApplication.dto.response.ProductDetailsResponse;
import com.Ecommerce.EcommerceApplication.dto.response.CommonAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Ecommerce.EcommerceApplication.service.EcommerceService;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class EcommerceController {

	@Autowired
	private EcommerceService productService;

	@GetMapping("productList")
	public ResponseEntity<CommonAPIResponse<List<ProductDetailsResponse>>> getAllProducts() {
		return productService.getAllProductsResponseEntity();
	}
	
	@PostMapping("getProductListByCategory")
	public ResponseEntity<CommonAPIResponse<List<ProductDetailsResponse>>> getProductListByCategory(@RequestBody ProductListByCategoryRequest reqBody){
		return productService.getProductListByCategory(reqBody);
	}
	
	@PostMapping("getCategoryMapping")
	public ResponseEntity<CommonAPIResponse<CategoryCountMappingResponse>> getCategoryMapping(){
		return productService.getCategoryMapping();
	}
}
