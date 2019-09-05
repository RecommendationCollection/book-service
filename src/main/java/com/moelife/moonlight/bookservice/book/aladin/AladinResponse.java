package com.moelife.moonlight.bookservice.book.aladin;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class AladinResponse {

	private Integer errorCode;

	private List<AladinBookInformation> item = new ArrayList<>();
}
