package com.Ecommerce.EcommerceApplication.service;

import java.util.ArrayList;
import java.util.List;

import com.Ecommerce.EcommerceApplication.dto.request.ProductListByCategoryRequest;
import com.Ecommerce.EcommerceApplication.dto.response.CategoryCountMappingResponse;
import com.Ecommerce.EcommerceApplication.dto.response.CategoryMapping;
import com.Ecommerce.EcommerceApplication.dto.response.ProductDetailsResponse;
import com.Ecommerce.EcommerceApplication.dto.response.CommonAPIResponse;
import com.Ecommerce.EcommerceApplication.mapper.DTOMapper;
import com.Ecommerce.EcommerceApplication.utils.enums.Category;
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
	
	public ResponseEntity<CommonAPIResponse<List<ProductDetailsResponse>>> getAllProductsResponseEntity() {
		CommonAPIResponse<List<ProductDetailsResponse>> response = new CommonAPIResponse<>(getAllProducts().stream().map(DTOMapper::BuildProductEntityToResponse).toList(), false);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<CommonAPIResponse<List<ProductDetailsResponse>>> getProductListByCategory(ProductListByCategoryRequest reqBody) {
		CommonAPIResponse<Object> response = new CommonAPIResponse<>();
		if ((reqBody == null) || (reqBody.getCategory() == null)) {
			response.setResponse(getAllProducts().stream().map(DTOMapper::BuildProductEntityToResponse).toList());
			response.setError(false);
			
			return new ResponseEntity(response, HttpStatus.OK);
		}
		
		var listProducts = getAllProducts().stream().filter(product -> product.getCategory().name().equalsIgnoreCase(reqBody.getCategory().name())).toList();
		response.setResponse(listProducts.stream().map(DTOMapper::BuildProductEntityToResponse).toList());
		response.setError(false);
		
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	public ResponseEntity<CommonAPIResponse<CategoryCountMappingResponse>> getCategoryMapping() {
		CategoryCountMappingResponse categoryMappingResponse = new CategoryCountMappingResponse();
		List<CategoryMapping> listOfCategoryMapping = new ArrayList<>();
		CategoryMapping categoryMappingAllObjects = new CategoryMapping();
		CommonAPIResponse<CategoryCountMappingResponse> commonResponse = new CommonAPIResponse<>();
		
		categoryMappingAllObjects.setLabel("ALL OBJECTS");
		categoryMappingAllObjects.setKey(null);
		listOfCategoryMapping.add(categoryMappingAllObjects);
		
		for (Category ct : Category.values()) {
			CategoryMapping cm = new CategoryMapping();
			cm.setKey(ct.name());
			cm.setLabel(ct.name());

			listOfCategoryMapping.add(cm);
		}
		
		categoryMappingResponse.setCategoryCount(listOfCategoryMapping.size());
		categoryMappingResponse.setCategoryMapping(listOfCategoryMapping);
		
		commonResponse.setError(false);
		commonResponse.setResponse(categoryMappingResponse);
		
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	private List<ProductDetails> getAllProducts() {
		return productRepo.findAll();
	}
}

