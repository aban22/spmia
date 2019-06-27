package com.thoughtmechanix.spmialicensingservice.model;

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
public class License {

	private String id;
	private String organizationId;
	private String productName;
	private String licenseType;
	
}
