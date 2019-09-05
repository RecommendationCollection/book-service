package com.moelife.moonlight.bookservice.book.aladin;

import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AladinAuthorInformationTest {

	@Test
	void parseNameAndTypeTest() {
		Map<String, TestAuthor> authorAnswerMap = TestAuthor.authorAnswer();

		for (String author : authorAnswerMap.keySet()) {
			TestAuthor answer = authorAnswerMap.get(author);

			assertEquals(answer.getName(), AladinAuthorInformation.getName(author));
			assertEquals(answer.getType(), AladinAuthorInformation.getAuthorType(author));
		}
	}
}