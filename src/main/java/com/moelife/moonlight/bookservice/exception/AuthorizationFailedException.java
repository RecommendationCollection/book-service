package com.moelife.moonlight.bookservice.exception;

import com.moelife.moonlight.bookservice.exception.support.ExceptionDetail;

import org.springframework.http.HttpStatus;

public class AuthorizationFailedException extends MoonlightException {

	public AuthorizationFailedException(ExceptionDetail detail, String message) {
		super(detail, message);
	}

	@Override
	int getStatusCode() {
		return HttpStatus.UNAUTHORIZED.value();
	}
}
