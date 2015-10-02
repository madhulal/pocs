package com.mozanta.store.user;

import javax.validation.Valid;

import com.mozanta.store.common.model.UserModel;
import com.mozanta.store.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("singleton")
public class UserRegistrationController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String loadRegistrationPage(final ModelMap model) {
		return "register";
	}

	@RequestMapping(value = "/Users", method = RequestMethod.POST, consumes = "application/json")
	public String addUser(@RequestBody @Valid UserModel userModel,
			final BindingResult result, final ModelMap model /* Address address */) {
		model.addAttribute("register", userModel);
		logger.info("errors ===>----------------------------: "
				+ userModel.getContactNumbers());
		userService.registerUser(userModel);
		return "result";
	}
}
