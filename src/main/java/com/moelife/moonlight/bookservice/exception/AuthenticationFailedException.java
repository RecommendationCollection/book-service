package com.moelife.moonlight.bookservice.exception;

import com.moelife.moonlight.bookservice.exception.support.ExceptionDetail;

import org.springframework.http.HttpStatus;

public class AuthenticationFailedException extends MoonlightException {

	public AuthenticationFailedException(ExceptionDetail detail, String message) {
		super(detail, message);
	}

	@Override
	int getStatusCode() {
		return HttpStatus.FORBIDDEN.value();
	}
}
