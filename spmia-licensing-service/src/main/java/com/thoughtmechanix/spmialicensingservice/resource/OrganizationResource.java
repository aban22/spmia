package com.thoughtmechanix.spmialicensingservice.resource;

import com.thoughtmechanix.spmialicensingservice.model.Organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class OrganizationResource {

    String organizationId;
    String name;
    String contactName;
    String contactEmail;
    String contactPhone;

    public OrganizationResource(Organization organization) {
    	if(organization != null) {
	        this.organizationId = organization.getOrganizationId();
	        this.name = organization.getName();
	        this.contactName = organization.getContactName();
	        this.contactEmail = organization.getContactEmail();
	        this.contactPhone = organization.getContactPhone();
    	}
    }
}
