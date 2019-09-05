package com.moelife.moonlight.bookservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

	@Bean
	public WebClient webClient(LoadBalancerClient loadBalancerClient) {
		return WebClient.builder()
				.filter(new LoadBalancerExchangeFilterFunction(loadBalancerClient))
				.build();
	}
}
