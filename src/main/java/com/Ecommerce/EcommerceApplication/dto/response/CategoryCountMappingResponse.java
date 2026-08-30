package com.Ecommerce.EcommerceApplication.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CategoryCountMappingResponse {
	private int categoryCount;
	private List<CategoryMapping> categoryMapping;
}
