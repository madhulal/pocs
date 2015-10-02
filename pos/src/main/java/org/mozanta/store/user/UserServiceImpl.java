package com.mozanta.store.user;

import com.mozanta.store.common.model.User;
import com.mozanta.store.common.model.UserModel;
import com.mozanta.store.common.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Madhulal M G on 12/9/15.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;

	/*
	 * private BCryptPasswordEncoder passwordEncoder = new
	 * BCryptPasswordEncoder();
	 */

/*	@Autowired
	private BCryptPasswordEncoder passwordEncoder;*/

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override  
	public void saveUser(UserModel userModel) {
		final User userEntity = new User();
		/*userEntity.setUserName(userModel.getUserName());
		userEntity
				.setPassWord(passwordEncoder.encode(userModel.getPassword1()));
		userRepository.save(userEntity);*/
	}

	@Override
	public void registerUser(UserModel userModel) {
		final User user = new User();
		user.setUserName(userModel.getUserName());
		user.setPassWord(userModel.getPassWord());
		user.setFirstName(userModel.getFirstName());
		user.setMiddleName(userModel.getMiddleName());
		user.setLastName(userModel.getLastName());
		user.setContactNumber(userModel.getContactNumbers())
		/*user.setGender(userModel.getGender());
		user.setMartialStatus(userModel.getMartialStatus());
		user.setDateOfBirth(userModel.getDateOfBirth());
		user.setAddress(userModel.getAddresses());
		user.setContactNumber(userModel.getContactNumbers())*/;
		logger.info("errors ===>++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++: " );
		userRepository.save(user);

	}
}
