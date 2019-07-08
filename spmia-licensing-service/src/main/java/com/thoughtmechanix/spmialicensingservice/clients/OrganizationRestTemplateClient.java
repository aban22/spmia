package com.thoughtmechanix.spmialicensingservice.clients;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;

import com.thoughtmechanix.spmialicensingservice.model.Organization;
import com.thoughtmechanix.spmialicensingservice.utils.UserContext;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Component
public class OrganizationRestTemplateClient {

//	private final RestTemplate restTemplate;
	private final OAuth2RestTemplate restTemplate;
	private final UserContext userContext;
	
	public Organization getOrganization(String organizationId){
		log.info("In Licensing Service.getOrganization: {}", userContext.getCorrelationId());
		ResponseEntity<Organization> restExchange =
				restTemplate.exchange(
						"http://spmia-organization-service/v1/organizations/{organizationId}", 
						HttpMethod.GET,
						null, 
						Organization.class, 
						organizationId);  
	    return restExchange.getBody();
	}
}
