package com.moelife.moonlight.bookservice.book.aladin;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AladinBookInformationTest {

	@Test
	void createAuthorInfo() {
		Map<String, List<TestAuthor>> authorsAnswer = TestAuthor.authorsAnswer();

		for (String authors : authorsAnswer.keySet()) {
			Set<TestAuthor> expect = new HashSet<>(authorsAnswer.get(authors));

			List<AladinAuthorInformation> authorInfos = ReflectionTestUtils.invokeMethod(new AladinBookInformation(), "createAuthorInfo", authors);
			assertNotNull(authorInfos);

			Set<TestAuthor> actual = authorInfos.stream()
					.map(info -> TestAuthor.of(info.getName(), info.getType()))
					.collect(Collectors.toSet());

			assertEquals(expect, actual);
		}
	}
}