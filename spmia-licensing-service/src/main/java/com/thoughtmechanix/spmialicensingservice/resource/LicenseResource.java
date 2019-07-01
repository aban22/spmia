package com.thoughtmechanix.spmialicensingservice.resource;

import com.thoughtmechanix.spmialicensingservice.model.License;

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
public class LicenseResource {

	private String licenseId;
	private String organizationId;
	private String productName;
	private String licenseType;
	private Integer licenseMax;
	private Integer licenseAllocated;
	private String comment;
	private OrganizationResource organization;
	
	public LicenseResource(License license, OrganizationResource organization) {
		this.licenseId = license.getLicenseId();
		this.organizationId = license.getOrganizationId();
		this.productName = license.getProductName();
		this.licenseType = license.getLicenseType();
		this.licenseMax = license.getLicenseMax();
		this.licenseAllocated = license.getLicenseAllocated();
		this.comment = license.getComment();
		this.organization = organization;
	}
}