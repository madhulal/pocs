package org.mare.pos.controller;

/**
 * Created by Madhulal M G on 10/10/15.
 */

import org.mare.pos.facade.OrganizationFacade;
import org.mare.pos.form.OrganizationCreateForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class OrganizationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    private final OrganizationFacade facade;

    @Autowired
    public OrganizationController(OrganizationFacade facade) {
        this.facade = facade;
    }

    @RequestMapping("/application/admin/organizations")
    public ModelAndView getOrganizationsPage() {
        LOGGER.debug("Getting Organizations page");
        return new ModelAndView("organizations", "organizations", facade.getAllOrganizations());
    }

    @RequestMapping(value = "/application/admin/organization/create", method = RequestMethod.GET)
    public ModelAndView getAddOrganizationPage() {
        LOGGER.debug("Getting Organizations Add page");
        return new ModelAndView("organization_create", "form", new OrganizationCreateForm());
    }

    @RequestMapping(value = "/application/admin/organization/create", method = RequestMethod.POST)
    public String  handleOrganizationCreateForm(@Valid @ModelAttribute("form") OrganizationCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing organization create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            return "organization_create";
        }

        facade.create(form);
        return "redirect:/application/admin/organizations";
    }

}
