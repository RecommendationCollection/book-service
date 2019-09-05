package com.moelife.moonlight.bookservice.book.support;

import org.springframework.web.util.UriComponents;

public interface BookInformationService {

	BookInformation getBookInformation(UriComponents uri);

	boolean isSupport(String domain);
}
