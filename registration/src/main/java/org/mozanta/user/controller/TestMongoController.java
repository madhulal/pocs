package org.mozanta.user.controller;

import org.mozanta.user.form.model.UserModel;
import org.mozanta.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * TODO Remove this file
 * Created by madhulal on 9/9/15.
 */
@Controller
public class TestMongoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView helloWorld() {
        List users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView("listUsers");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public ModelAndView showAddUserForm() {
        ModelAndView modelAndView = new ModelAndView("testForm");
        modelAndView.getModel().put("userForm", new UserModel());
        return modelAndView;
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm") UserModel userModel) {
        logger.info("name from model: " + userModel.getUsername());
        logger.info("name from model: " + userModel.getPassword1());
        userService.saveUser(userModel);
        return "redirect:/users";
    }
}
