package com.moelife.moonlight.bookservice.book.aladin;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.moelife.moonlight.bookservice.book.AuthorType;
import com.moelife.moonlight.bookservice.book.support.AuthorInformation;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
class AladinAuthorInformation implements AuthorInformation {

	private static Map<String, AuthorType> typeMap = new HashMap<>();
	private static String authorTypeRegex;

	static {
		typeMap.put("원작", AuthorType.ORIGIN);
		typeMap.put("지은이", AuthorType.WRITER);
		typeMap.put("글", AuthorType.STORY_WRITER);
		typeMap.put("스토리 작가", AuthorType.STORY_WRITER);

		typeMap.put("그림", AuthorType.PAINTER);
		typeMap.put("작화", AuthorType.PAINTER);

		typeMap.put("엮은이", AuthorType.COMPILER);
		typeMap.put("옮긴이", AuthorType.TRANSLATOR);

		authorTypeRegex = "\\((" + String.join("|", typeMap.keySet()) + ")\\)";
	}

	private String name;
	private AuthorType type;

	AladinAuthorInformation(String name, AuthorType type) {

		this.name = name;
		this.type = type;
	}

	static AuthorType getAuthorType(String author) {
		String typeString = StringUtils.substringAfterLast(author, "(").replaceAll("[()]", "");
		return Optional.ofNullable(typeMap.get(typeString)).orElse(AuthorType.NONE);
	}

	static String getName(String author) {
		return author.replaceAll(authorTypeRegex, "").trim();
	}
}
