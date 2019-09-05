package com.moelife.moonlight.bookservice.exception;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private final Log logger = LogFactory.getLog(getClass());

	private final MessageSource messageSource;

	public GlobalExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(MoonlightException.class)
	public ResponseEntity<?> moonlightExceptionHandler(MoonlightException e) {
		logger.debug(e.getMessage());

		String responseMessage = messageSource.getMessage(e.getMessageCode(), null, LocaleContextHolder.getLocale());

		return ResponseEntity.status(e.getStatusCode())
				.body(ResponseBody.of(e.getCode(), responseMessage));
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String unknownExceptionHandler(Exception e) {
		logger.error(e.getMessage(), e);

		return "내부 서버 에러";
	}

	protected static class ResponseBody {

		private int code;

		private String message;

		private LocalDateTime responseTime;

		private ResponseBody(int code, String message, LocalDateTime responseTime) {
			this.code = code;
			this.message = message;
			this.responseTime = responseTime;
		}

		static ResponseBody of(int code, String message) {
			return new ResponseBody(code, message, LocalDateTime.now());
		}

		public int getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		public LocalDateTime getResponseTime() {
			return responseTime;
		}
	}
}