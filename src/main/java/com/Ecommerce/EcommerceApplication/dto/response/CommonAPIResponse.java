package com.Ecommerce.EcommerceApplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonAPIResponse<T> {
	private T response;
	private boolean isError;
}
