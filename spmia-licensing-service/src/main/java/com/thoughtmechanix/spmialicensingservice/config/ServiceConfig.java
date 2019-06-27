package com.thoughtmechanix.spmialicensingservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ServiceConfig {

	@Value("${example.property}")
	private String exampleProperty;
	
}
