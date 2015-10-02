package com.mozanta.store.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mozanta.store.entity.Manufactures;

public interface ManufacturesRepository extends MongoRepository<Manufactures, String>{

}
