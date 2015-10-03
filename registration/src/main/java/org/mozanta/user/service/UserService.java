package org.mozanta.user.service;

import org.mozanta.user.entity.User;
import org.mozanta.user.form.model.UserModel;

import java.util.List;

/**
 * Created by Madhulal M G on 12/9/15.
 */
public interface UserService {
    List<User> getAllUsers();

    void saveUser(final UserModel user);
}
