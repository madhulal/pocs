package org.mozanta.user.repository;

import org.mozanta.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by madhulal on 9/9/15.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public List<User> findByUsername(String username);

}
