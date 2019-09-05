package com.moelife.moonlight.bookservice.exception;

import com.moelife.moonlight.bookservice.exception.support.ExceptionDetail;
import lombok.Getter;

@Getter
public enum Detail implements ExceptionDetail {
	BOOK_URI_ERROR(100, "error.book.uri");

	private final int code;

	private final String messageCode;

	Detail(int code, String messageCode) {
		this.code = code;
		this.messageCode = messageCode;
	}
}
