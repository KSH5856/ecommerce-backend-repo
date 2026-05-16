package com.Ecommerce.EcommerceApplication.dto.response;

import com.Ecommerce.EcommerceApplication.utils.enums.Category;
import lombok.Data;

@Data
public class ProductDetailsResponse {
	
	private long productId;
	private String title;
	private String description;
	private Category category;
	private double price;
//	private int stockCount;
	private String images;
}
