package com.thoughtmechanix.spmiaorganizationservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtmechanix.spmiaorganizationservice.model.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {
	
	public Organization findByOrganizationId(String organizationId);
	
}
