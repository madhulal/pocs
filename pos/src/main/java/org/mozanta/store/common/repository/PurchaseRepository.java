package com.mozanta.store.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mozanta.store.entity.Purchase;

public interface PurchaseRepository extends MongoRepository<Purchase, String>{

}
