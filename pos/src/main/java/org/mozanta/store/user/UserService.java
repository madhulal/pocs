package com.mozanta.store.user;

import java.util.List;


import com.mozanta.store.common.model.User;
import com.mozanta.store.common.model.UserModel;

/**
 * Created by Madhulal M G on 12/9/15.
 */
public interface UserService {
	List<User> getAllUsers();

	void saveUser(final UserModel user);

	void registerUser(final UserModel userModel);
	
}
