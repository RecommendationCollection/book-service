package com.moelife.moonlight.bookservice.book.aladin;

import java.util.Optional;

import com.moelife.moonlight.bookservice.book.support.BookInformation;
import com.moelife.moonlight.bookservice.book.support.BookInformationService;
import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class AladinBookInformationService implements BookInformationService {

	private static final String DOMAIN = "www.aladin.co.kr";

	private static final String URI_TEMPLATE = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx";

	private static final String[] ITEM_ID_TYPES = {"ItemId", "ISBN", "ISBN13"};

	private final AladinProperties properties;

	private final WebClient webClient;

	public AladinBookInformationService(AladinProperties properties, WebClient.Builder webClientBuilder) {
		this.properties = properties;
		this.webClient = webClientBuilder.baseUrl(DOMAIN).build();
	}

	@Override
	public boolean isSupport(String domain) {
		String wwwDomain = Optional.ofNullable(domain).orElse("");

		if (!wwwDomain.contains("www")) {
			wwwDomain = "www." + domain;
		}

		return wwwDomain.equals(DOMAIN);
	}

	@Override
	public BookInformation getBookInformation(UriComponents uri) {
		String apiRequestUri = getRequestUri(uri);

		Optional<AladinResponse> response = webClient.get().uri(apiRequestUri)
				.retrieve()
				.bodyToMono(AladinResponse.class)
				.blockOptional();

		BookInformation information = BookInformation.NONE;

		if (response.isPresent() && isResponseHaveItem(response.get())) {
			information = response.get().getItem().get(0);
		}

		return information;
	}

	private boolean isResponseHaveItem(AladinResponse response) {
		return response.getErrorCode() == null && !response.getItem().isEmpty();
	}

	private String getRequestUri(UriComponents uri) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URI_TEMPLATE)
				.queryParam("Version", properties.getVersion())
				.queryParam("ttbkey", properties.getTtbKey())
				.queryParam("output", "js");

		for (String type : ITEM_ID_TYPES) {
			String searchId = uri.getQueryParams().getFirst(type);

			if (StringUtils.isNotBlank(searchId)) {
				builder.queryParam("itemIdType", type);
				builder.queryParam("ItemId", searchId);
			}
		}

		return builder.build().toUriString();
	}
}
