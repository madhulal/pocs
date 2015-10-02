
package com.mozanta.store.common.repository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class BaseDao {

	public MongoOperations mongoOperation() {

		final ApplicationContext context = new AnnotationConfigApplicationContext(
				MongoConfig.class);
		final MongoOperations operations = (MongoOperations) context
				.getBean("mongoTemplate");
		return operations;

	}

}
