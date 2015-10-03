package org.mozanta.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by madhulal on 9/9/15.
 */
@Controller
@RequestMapping("/user/register")
public class RegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public String loadRegistrationPage(ModelMap model) {
        return "register";
    }
}
