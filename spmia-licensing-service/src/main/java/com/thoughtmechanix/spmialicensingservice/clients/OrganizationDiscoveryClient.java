package com.thoughtmechanix.spmialicensingservice.clients;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.thoughtmechanix.spmialicensingservice.model.Organization;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrganizationDiscoveryClient {

	private final DiscoveryClient discoveryClient;
	
	public Organization getOrganization(String organizationId) {
		RestTemplate restTemplate = new RestTemplate();
		List<ServiceInstance> instances = discoveryClient.getInstances("SPMIA-ORGANIZATION-SERVICE");
		
		if(instances.isEmpty()) {
			return null;
		}
		String serviceUri = String.format("%s/v1/organizations/%s", instances.get(0).getUri().toString(), organizationId);
		
		ResponseEntity< Organization > restExchange =      
		        restTemplate.exchange(
		            serviceUri,
		            HttpMethod.GET,
		            null, 
		            Organization.class, 
		            organizationId);
		return restExchange.getBody();
	}
}
