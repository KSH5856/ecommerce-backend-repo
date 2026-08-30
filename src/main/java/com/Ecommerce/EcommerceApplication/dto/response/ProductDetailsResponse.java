package com.Ecommerce.EcommerceApplication.dto.response;

import com.Ecommerce.EcommerceApplication.utils.enums.Category;
import lombok.Data;

@Data
public class ProductDetailsResponse {
	
	private long productId;
	private String title;
	private String description;
	private Category category;
	private boolean isLiked = false;
	private double price;
	private String images;
}
