package com.thoughtmechanix.spmiaorganizationservice.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.thoughtmechanix.spmiaorganizationservice.model.Organization;
import com.thoughtmechanix.spmiaorganizationservice.repository.OrganizationRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrganizationService {

	private final OrganizationRepository organizationRepository;
	
	public Organization getOrganization(String organizationId) {
		return organizationRepository.findByOrganizationId(organizationId);
	}
	
	public void saveOrganization(Organization organization) {
		organization.setOrganizationId(UUID.randomUUID().toString());
		organizationRepository.save(organization);
	}
	
	public void updateOrganization(Organization organization) {
		organizationRepository.save(organization);
	}
	
	public void deleteOrganization(Organization organization) {
		organizationRepository.deleteById(organization.getOrganizationId());
	}
}
