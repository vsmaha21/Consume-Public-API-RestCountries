package com.rest.countries.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(HttpClientErrorException.class)
	public Map<String, Object> handleGlobalException(HttpClientErrorException ex) {
		// Custom logic for handling exceptions

		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("errorCode", "RESOURCE_NOT_FOUND");
		errorResponse.put("message", ex.getMessage());
		errorResponse.put("details", "The requested resource could not be found");

		return errorResponse;
	}
}
