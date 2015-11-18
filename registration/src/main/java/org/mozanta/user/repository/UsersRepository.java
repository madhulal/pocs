package org.mozanta.user.repository;

import org.mozanta.user.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by madhulal on 9/9/15.
 */
@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    public List<Users> findByUsername(String username);
}
