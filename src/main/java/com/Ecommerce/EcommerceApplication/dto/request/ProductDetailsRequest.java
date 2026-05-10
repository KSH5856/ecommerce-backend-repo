package com.Ecommerce.EcommerceApplication.dto.request;

import com.Ecommerce.EcommerceApplication.utils.enums.Category;
import lombok.Data;

@Data
public class ProductDetailsRequest {
	private String title;
	private String description;
	private Category category;
	private double price;
	private int stockCount = 1;
	private String images;
}