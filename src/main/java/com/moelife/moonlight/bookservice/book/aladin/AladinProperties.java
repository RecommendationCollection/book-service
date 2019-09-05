package com.moelife.moonlight.bookservice.book.aladin;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter

@Component
@ConfigurationProperties("aladin")
public class AladinProperties {

	private String ttbKey;

	private String version = "20131101";
}
