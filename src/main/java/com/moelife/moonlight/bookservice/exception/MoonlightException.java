package com.moelife.moonlight.bookservice.exception;

import com.moelife.moonlight.bookservice.exception.support.ExceptionDetail;

abstract class MoonlightException extends RuntimeException {

	private final ExceptionDetail detail;

	MoonlightException(ExceptionDetail detail, String message) {
		super(message);
		this.detail = detail;
	}

	int getCode() {
		return this.detail.getCode();
	}

	String getMessageCode() {
		return this.detail.getMessageCode();
	}

	abstract int getStatusCode();
}
