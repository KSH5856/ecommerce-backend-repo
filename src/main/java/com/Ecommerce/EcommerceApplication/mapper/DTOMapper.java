package com.Ecommerce.EcommerceApplication.mapper;

import com.Ecommerce.EcommerceApplication.dto.request.ProductDetailsRequest;
import com.Ecommerce.EcommerceApplication.entity.ProductDetails;

public class DTOMapper {
	
	// Converts productDetails Request to entity of productDetails
	public static ProductDetails BuildProductRequest(ProductDetailsRequest request){
		ProductDetails newProduct = new ProductDetails();
		newProduct.setCategory(request.getCategory());
		newProduct.setTitle(request.getTitle());
		newProduct.setPrice(request.getPrice());
		newProduct.setImages(request.getImages());
		newProduct.setDescription(request.getDescription());
		newProduct.setStockCount(request.getStockCount());
		
		return newProduct;
	}
	
}
