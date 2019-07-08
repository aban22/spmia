package com.thoughtmechanix.spmiaorganizationservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtmechanix.spmiaorganizationservice.model.Organization;
import com.thoughtmechanix.spmiaorganizationservice.services.OrganizationService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("v1/organizations")
public class OrganizationServiceController {

	private final OrganizationService organizationService;

	@GetMapping("/{organizationId}")
	public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
		return organizationService.getOrganization(organizationId);
	}

	@PutMapping("/{organizationId}")
	public void updateOrganization(@PathVariable("organizationId") String orgId, @RequestBody Organization organization) {
		organizationService.updateOrganization(organization);
	}

	@PostMapping("/{organizationId}")
	public void saveOrganization(@RequestBody Organization organization) {
		organizationService.saveOrganization(organization);
	}

	@DeleteMapping("/{organizationId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOrganization(@PathVariable("organizationId") String organizationId) {
		log.info("deleteOrganization Data IN => organizationId: {}", organizationId);
//		organizationService.deleteOrganization(organization);
	}
}
