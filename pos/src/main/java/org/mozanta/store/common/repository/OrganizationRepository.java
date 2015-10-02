package com.mozanta.store.common.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mozanta.store.entity.Manufactures;
import com.mozanta.store.entity.Organization;

public interface OrganizationRepository extends MongoRepository<Organization, String> {

	

}
