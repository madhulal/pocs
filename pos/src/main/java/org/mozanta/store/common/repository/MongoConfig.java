/*
 * cloudstore - mozanta
 *
 * Copyright 2015 Mozanta Technologies All Rights Reserved.
 */
package com.mozanta.store.common.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public class MongoConfig {
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {

		final MongoClientOptions options = MongoClientOptions.builder()
				.connectionsPerHost(10)
				.threadsAllowedToBlockForConnectionMultiplier(4)
				.connectTimeout(1000).maxWaitTime(1500).socketKeepAlive(true)
				.socketTimeout(1500)
				.writeConcern(new WriteConcern().withFsync(true)).build();

		final MongoClient client = new MongoClient(new ServerAddress(
				"localhost", 27017), options);
		return new SimpleMongoDbFactory(client, "store-db");
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		final MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}

}
