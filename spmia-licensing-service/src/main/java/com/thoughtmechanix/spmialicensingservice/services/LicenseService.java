package com.thoughtmechanix.spmialicensingservice.services;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

	private void randomlyRunLong(){
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		if(randomNum==3) {
			sleep();
		}
	}

	private void sleep(){
		try {
			Thread.sleep(11000);                        
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public License buildFallbackLicense(String organizationId, String licenseId) {
		return License.builder()
				.licenseId("0000000-00-00000")
				.productName("Sorry no licensing information currently available")
				.build();
	}
	
//	@HystrixCommand(commandProperties={@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="12000")})
//	@HystrixCommand(fallbackMethod = "buildFallbackLicense")
//	@HystrixCommand(
//			fallbackMethod = "buildFallbackLicense",
//			threadPoolKey = "licenseByOrgThreadPool",              
//			threadPoolProperties = {@HystrixProperty(name = "coreSize",value="30"), @HystrixProperty(name="maxQueueSize", value="10")})
	@HystrixCommand(
			fallbackMethod = "buildFallbackLicense",
			threadPoolKey = "licenseByOrgThreadPool",
			threadPoolProperties = {@HystrixProperty(name = "coreSize", value="30"), @HystrixProperty(name = "maxQueueSize", value="10")},
			commandProperties = {
					@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"), 
					@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="75"),
					@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000"),                
					@HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="15000"),
					@HystrixProperty(name="metrics.rollingStats.numBuckets", value="5")})   
	public License getLicense(String organizationId, String licenseId) {
		randomlyRunLong();
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
            organization = retrieveOrganizationInfoRestTemplateClient(organizationId);
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

	@HystrixCommand
	private Organization retrieveOrganizationInfoRestTemplateClient(String organizationId) {
		return organizationRestTemplateClient.getOrganization(organizationId);
	}
	
	public List<License> getLicensesByOrg(String organizationId) {
		return licenseRepository.findByOrganizationId(organizationId);
	}

	public void saveLicense(License license) {
		license.setLicenseId(UUID.randomUUID().toString());
	}
}
