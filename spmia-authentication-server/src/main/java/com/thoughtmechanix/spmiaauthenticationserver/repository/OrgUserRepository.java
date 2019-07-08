package com.thoughtmechanix.spmiaauthenticationserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtmechanix.spmiaauthenticationserver.model.UserOrganization;

@Repository
public interface OrgUserRepository extends CrudRepository<UserOrganization, String> {

    public UserOrganization findByUserName(String userName);

}
