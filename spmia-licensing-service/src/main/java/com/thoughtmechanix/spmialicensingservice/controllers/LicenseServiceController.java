package com.thoughtmechanix.spmialicensingservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtmechanix.spmialicensingservice.model.License;
import com.thoughtmechanix.spmialicensingservice.resource.LicenseResource;
import com.thoughtmechanix.spmialicensingservice.services.LicenseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

	private final LicenseService licenseService;
	
	@GetMapping("/{licenseId}")
	public License getLicenses(@PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId) {
		return licenseService.getLicense(organizationId, licenseId);
	}
	
	@GetMapping("/{licenseId}/{clientType}")
	public LicenseResource getLicensesWithClient(@PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId, @PathVariable("clientType") String clientType) {
		return licenseService.getLicense(organizationId, licenseId, clientType);
	}
}
