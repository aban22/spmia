package com.thoughtmechanix.spmialicensingservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.thoughtmechanix.spmialicensingservice.clients.OrganizationDiscoveryClient;
import com.thoughtmechanix.spmialicensingservice.clients.OrganizationFeignClient;
import com.thoughtmechanix.spmialicensingservice.clients.OrganizationRestTemplateClient;
import com.thoughtmechanix.spmialicensingservice.config.ServiceConfig;
import com.thoughtmechanix.spmialicensingservice.model.License;
import com.thoughtmechanix.spmialicensingservice.model.Organization;
import com.thoughtmechanix.spmialicensingservice.repository.LicenseRepository;
import com.thoughtmechanix.spmialicensingservice.resource.LicenseResource;
import com.thoughtmechanix.spmialicensingservice.resource.OrganizationResource;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class LicenseService {

	private final LicenseRepository licenseRepository;
	private final ServiceConfig serviceConfig;
	private final OrganizationDiscoveryClient organizationDiscoveryClient;
	private final OrganizationFeignClient organizationFeignClient;
	private final OrganizationRestTemplateClient organizationRestTemplateClient;
	
	public License getLicense(String organizationId, String licenseId) {
		License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
		license.setComment(serviceConfig.getExampleProperty());
		return license;
	}
	
    public LicenseResource getLicense(String organizationId,String licenseId, String clientType) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        Organization organization = retrieveOrganizationInfo(organizationId, clientType);

        return new LicenseResource(license, new OrganizationResource(organization));

    }
	
	public Organization retrieveOrganizationInfo(String organizationId, String clientType) {
        Organization organization = null;
        switch (clientType) {
        case "feign":
            log.info("I am using the feign client");
            organization = organizationFeignClient.getOrganization(organizationId);
            break;
        case "rest":
        	log.info("I am using the rest client");
            organization = organizationRestTemplateClient.getOrganization(organizationId);
            break;
        case "discovery":
        	log.info("I am using the discovery client");
            organization = organizationDiscoveryClient.getOrganization(organizationId);
            break;
        default:
            organization = organizationRestTemplateClient.getOrganization(organizationId);
    }
        return organization;
	}

	public List<License> getLicensesByOrg(String organizationId) {
		return licenseRepository.findByOrganizationId(organizationId);
	}

	public void saveLicense(License license) {
		license.setLicenseId(UUID.randomUUID().toString());
	}
}
