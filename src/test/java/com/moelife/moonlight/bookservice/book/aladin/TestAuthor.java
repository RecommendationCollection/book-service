package com.moelife.moonlight.bookservice.book.aladin;

import java.util.*;

import com.moelife.moonlight.bookservice.book.AuthorType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
class TestAuthor {
	private String name;
	private AuthorType type;

	static TestAuthor of(String name, AuthorType type) {
		TestAuthor author = new TestAuthor();
		author.name = name;
		author.type = type;
		return author;
	}

	static Map<String, TestAuthor> authorAnswer() {
		Map<String, TestAuthor> authorAnswer = new HashMap<>();

		authorAnswer.put("김민재 (옮긴이)",
				TestAuthor.of("김민재", AuthorType.TRANSLATOR));

		authorAnswer.put("고아웃 편집부 (지은이)",
				TestAuthor.of("고아웃 편집부", AuthorType.WRITER));

		authorAnswer.put("하이라이츠 어린이 (Highlights for Children) (지은이)",
				TestAuthor.of("하이라이츠 어린이 (Highlights for Children)", AuthorType.WRITER));

		authorAnswer.put("손은호 (스토리 작가)",
				TestAuthor.of("손은호", AuthorType.STORY_WRITER));

		authorAnswer.put("기시모토 마사시 (원작)",
				TestAuthor.of("기시모토 마사시", AuthorType.ORIGIN));

		return authorAnswer;
	}

	static Map<String, List<TestAuthor>> authorsAnswer() {
		Map<String, List<TestAuthor>> authorsAnswer = new HashMap<>();

		authorsAnswer.put("손은호 (스토리 작가), 최명수 (작화)",
				Arrays.asList(TestAuthor.of("손은호", AuthorType.STORY_WRITER),
						TestAuthor.of("최명수", AuthorType.PAINTER)));

		authorsAnswer.put("이케모토 미키오, 코다치 우쿄 (지은이), 기시모토 마사시 (원작)",
				Arrays.asList(TestAuthor.of("이케모토 미키오", AuthorType.WRITER),
						TestAuthor.of("코다치 우쿄", AuthorType.WRITER),
						TestAuthor.of("기시모토 마사시", AuthorType.ORIGIN)));

		authorsAnswer.put("Billboard Magazine",
				Collections.singletonList(TestAuthor.of("Billboard Magazine", AuthorType.NONE)));

		return authorsAnswer;
	}
}
