package com.test.userlogin.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandaler {
	@ExceptionHandler
	public ResponseEntity handleException(Exception e) {
		APIResponse apiResponse=new APIResponse();
		apiResponse.setToken("token is not generated invalid email and password");
		apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(apiResponse);
		
	}

}
