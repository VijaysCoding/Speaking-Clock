package com.example.clock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTimeFormatException extends RuntimeException{
	public InvalidTimeFormatException(String msg) {
		super(msg);
	}

}
