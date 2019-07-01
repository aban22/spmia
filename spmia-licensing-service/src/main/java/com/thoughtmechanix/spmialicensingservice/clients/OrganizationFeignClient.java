package com.thoughtmechanix.spmialicensingservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.thoughtmechanix.spmialicensingservice.model.Organization;

@FeignClient("spmia-organization-service")
public interface OrganizationFeignClient {
	
	@GetMapping("/v1/organizations/{organizationId}")
	public Organization getOrganization(@PathVariable("organizationId") String organizationId);
	
}
