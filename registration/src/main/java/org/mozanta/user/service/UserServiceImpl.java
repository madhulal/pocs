package org.mozanta.user.service;

import org.mozanta.user.entity.User;
import org.mozanta.user.form.model.UserModel;
import org.mozanta.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Madhulal M G on 12/9/15.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(UserModel userModel) {
        final User userEntity = new User();
        userEntity.setUsername(userModel.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userModel.getPassword1()));
        userRepository.save(userEntity);
    }
}
