package com.onlineshopping.os.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Bean
	@LoadBalanced // client side load balancer and will call the services one after another.
	public WebClient.Builder webClient() {
		return WebClient.builder();
	}
}
