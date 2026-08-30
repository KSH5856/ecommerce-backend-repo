package com.Ecommerce.EcommerceApplication.globalExceptionHandler;

import com.Ecommerce.EcommerceApplication.dto.response.CommonAPIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EcommerceGlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CommonAPIResponse<String>> handleGeneral(Exception ex) {
		CommonAPIResponse<String> response = new CommonAPIResponse<>(ex.getMessage(), true);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
