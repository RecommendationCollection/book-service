package com.moelife.moonlight.bookservice.book;

import java.util.List;

import com.moelife.moonlight.bookservice.book.support.BookInformation;
import com.moelife.moonlight.bookservice.book.support.BookInformationService;
import com.moelife.moonlight.bookservice.exception.Detail;
import com.moelife.moonlight.bookservice.exception.IllegalArgumentException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
public class BookInformationManager {

	private final List<BookInformationService> services;

	public BookInformationManager(List<BookInformationService> services) {
		this.services = services;
	}

	public BookInformation getInformation(String uri) {
		UriComponents uriComponents = UriComponentsBuilder.fromUriString(uri).build();

		String domain = uriComponents.getHost();

		BookInformationService service = services.stream()
				.filter(s -> s.isSupport(domain))
				.findFirst().orElseThrow(() -> new IllegalArgumentException(Detail.BOOK_URI_ERROR, uriComponents.getHost() + "에 해당하는 로더를 찾지 못 했습니다."));

		return service.getBookInformation(uriComponents);
	}
}
