package org.mare.pos.repositories;

import org.mare.pos.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/**
 * Created by Madhulal M G on 10/10/15.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
}
