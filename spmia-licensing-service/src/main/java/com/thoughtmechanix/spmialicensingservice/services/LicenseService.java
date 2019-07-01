package com.thoughtmechanix.spmialicensingservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.thoughtmechanix.spmialicensingservice.config.ServiceConfig;
import com.thoughtmechanix.spmialicensingservice.model.License;
import com.thoughtmechanix.spmialicensingservice.repository.LicenseRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LicenseService {

	private final LicenseRepository licenseRepository;
	private final ServiceConfig serviceConfig;
	
	public License getLicense(String organizationId, String licenseId) {
		License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
		license.setComment(serviceConfig.getExampleProperty());
		return license;
	}
	
	public License getLicense(String organizationId, String licenseId, String clientType) {
		License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
		license.setComment(serviceConfig.getExampleProperty());
		return license;
	}

	public List<License> getLicensesByOrg(String organizationId) {
		return licenseRepository.findByOrganizationId(organizationId);
	}

	public void saveLicense(License license) {
		license.setLicenseId(UUID.randomUUID().toString());
	}
}
