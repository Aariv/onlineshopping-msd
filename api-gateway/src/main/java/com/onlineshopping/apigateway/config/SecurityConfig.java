package com.onlineshopping.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity // It is not web mvc so enabled web flux
public class SecurityConfig {

	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
		serverHttpSecurity.csrf()
		.disable()
		.authorizeExchange(exchange -> exchange
				.pathMatchers("/eureka/**")
				.permitAll()
				.anyExchange()
				.authenticated())
		.oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
		return serverHttpSecurity.build();
	}
}
