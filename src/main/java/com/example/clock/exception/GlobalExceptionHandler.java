package com.example.clock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(InvalidTimeFormatException.class)
	public ResponseEntity<ApiError> handleInvalidTime(InvalidTimeFormatException e){
		return new ResponseEntity<>(new ApiError("INVALID_TIME", e.getMessage()), HttpStatus.BAD_REQUEST);
	}

}
