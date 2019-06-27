package com.thoughtmechanix.spmialicensingservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "licenses")
public class License {

	@Id
	@Column(name = "license_id", nullable = false) 
	private String licenseId;
	
	@Column(name = "organization_id", nullable = false)
	private String organizationId;
	
	@Column(name = "product_name", nullable = false)
	private String productName;
	
	@Column(name = "license_type", nullable = false)
	private String licenseType;
	
	@Column(name = "license_max", nullable = false)
	private Integer licenseMax;
	
	@Column(name = "license_allocated", nullable = true)
	private Integer licenseAllocated;
	
	@Column(name = "comment", nullable = true)
	private String comment;
}
