package com.Ecommerce.EcommerceApplication.mapper;

import com.Ecommerce.EcommerceApplication.dto.response.ProductDetailsResponse;
import com.Ecommerce.EcommerceApplication.entity.ProductDetails;

public class DTOMapper {
	
	public static ProductDetailsResponse BuildProductEntityToResponse(ProductDetails request){
		ProductDetailsResponse newProduct = new ProductDetailsResponse();
		newProduct.setProductId((request.getProductId()));
		newProduct.setCategory(request.getCategory());
		newProduct.setTitle(request.getTitle());
		newProduct.setPrice(request.getPrice());
		newProduct.setImages(request.getImages());
		newProduct.setDescription(request.getDescription());
		newProduct.setLiked(request.isLiked());
		return newProduct;
	}
}
