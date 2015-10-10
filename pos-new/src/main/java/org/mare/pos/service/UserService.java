package org.mare.pos.service;

/**
 * Created by Madhulal M G on 10/10/15.
 */
import org.mare.pos.domain.User;
import org.mare.pos.form.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
