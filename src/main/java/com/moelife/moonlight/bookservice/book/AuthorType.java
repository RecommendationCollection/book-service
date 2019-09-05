package com.moelife.moonlight.bookservice.book;

import com.moelife.moonlight.bookservice.model.ValueEnum;
import lombok.Getter;

@Getter
public enum AuthorType implements ValueEnum {
	NONE(0, "작가 타입 없음"),

	ORIGIN(1000, "원작가"),
	WRITER(1001, "지은이"),
	STORY_WRITER(1002, "스토리 작가"),

	PAINTER(1100, "그림"),

	TRANSLATOR(1200, "옮긴이"),
	COMPILER(1201, "엮은이");

	private final int value;

	private final String description;

	AuthorType(int value, String description) {
		this.value = value;
		this.description = description;
	}

	@javax.persistence.Converter
	public static class Converter extends ValueEnum.Converter<AuthorType> {
		public Converter() {
			super(AuthorType.class);
		}
	}
}
