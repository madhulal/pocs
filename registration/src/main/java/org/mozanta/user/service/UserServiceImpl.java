package org.mozanta.user.service;

import org.mozanta.user.entity.Users;
import org.mozanta.user.form.model.UserModel;
import org.mozanta.user.repository.UsersRepository;
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
    private UsersRepository usersRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void saveUser(UserModel userModel) {
        final Users userEntity = new Users();
        userEntity.setUsername(userModel.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userModel.getPassword1()));
        usersRepository.save(userEntity);
    }
}
