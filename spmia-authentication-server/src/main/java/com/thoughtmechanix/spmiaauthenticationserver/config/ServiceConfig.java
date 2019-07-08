package com.thoughtmechanix.spmiaauthenticationserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
@Configuration
public class ServiceConfig {

	@Value("${signing.key}")
	private String jwtSigningKey = "";
	
}
