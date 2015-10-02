package com.mozanta.store.common.repository;

import com.mozanta.store.common.model.ProductModel;
import com.mozanta.store.common.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by madhulal on 9/9/15.
*/

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public List<User> findByUserName(String userName);
	

}
