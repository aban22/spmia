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
public class Organization {

    String organizationId;
    String name;
    String contactName;
    String contactEmail;
    String contactPhone;
    
}
