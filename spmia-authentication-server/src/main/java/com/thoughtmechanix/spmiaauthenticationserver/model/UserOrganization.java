package com.thoughtmechanix.spmiaauthenticationserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_orgs")
public class UserOrganization {

	@Column(name = "organization_id", nullable = false)
    private String organizationId;

    @Id
    @Column(name = "user_name", nullable = false)
    private String userName;
    
}
