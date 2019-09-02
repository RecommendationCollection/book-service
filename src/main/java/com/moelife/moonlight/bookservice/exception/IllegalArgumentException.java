package com.moelife.moonlight.bookservice.exception;

import com.moelife.moonlight.bookservice.exception.support.ExceptionDetail;

import org.springframework.http.HttpStatus;

public class IllegalArgumentException extends MoonlightException {

	public IllegalArgumentException(ExceptionDetail detail, String message) {
		super(detail, message);
	}

	@Override
	int getStatusCode() {
		return HttpStatus.BAD_REQUEST.value();
	}
}
