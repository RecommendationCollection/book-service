package com.moelife.moonlight.bookservice.exception;

import com.moelife.moonlight.bookservice.exception.support.ExceptionDetail;

import org.springframework.http.HttpStatus;

public class NotFoundException extends MoonlightException {

	public NotFoundException(ExceptionDetail detail, String message) {
		super(detail, message);
	}

	@Override
	int getStatusCode() {
		return HttpStatus.NOT_FOUND.value();
	}
}
