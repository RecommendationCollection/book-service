package com.moelife.moonlight.bookservice.bookauthor;

import com.moelife.moonlight.bookservice.model.ValueEnum;
import lombok.Getter;

@Getter
public enum AuthorType implements ValueEnum {
	WRITER(1000, "지은이"),
	PAINTER(1001, "그림"),
	TRANSLATOR(1005, "옮긴이")
	;

	private final int value;

	private final String description;

	AuthorType(int value, String description) {
		this.value = value;
		this.description = description;
	}

	@javax.persistence.Converter
	public static class Converter extends ValueEnum.Converter<AuthorType> {
		protected Converter() {
			super(AuthorType.class);
		}
	}
}
