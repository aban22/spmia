package com.thoughtmechanix.spmialicensingservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtmechanix.spmialicensingservice.model.License;

@RestController
@RequestMapping("/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

	@GetMapping("/{licenseId}")
	public License getLicenses(@PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId) {
		return License.builder()
				.licenseId(licenseId)
				.productName("Teleco")
				.licenseType("Seat")
				.organizationId("TestOrg")
				.build();
	}
}
