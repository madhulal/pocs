package com.mozanta.store.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mozanta.store.entity.Stock;

public interface StockRepository extends MongoRepository<Stock, String>{
	
	

}
