package com.mozanta.store.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mozanta.store.entity.Vendors;

public interface VendorsRepository extends MongoRepository<Vendors, String>{

}
