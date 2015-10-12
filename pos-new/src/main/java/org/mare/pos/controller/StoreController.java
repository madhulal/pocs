package org.mare.pos.controller;

/**
 * Created by Madhulal M G on 10/10/15.
 */

import org.mare.pos.domain.CurrentUser;
import org.mare.pos.facade.StoreFacade;
import org.mare.pos.form.StoreCreateForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StoreController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

    private final StoreFacade facade;

    @Autowired
    public StoreController(StoreFacade facade) {
        this.facade = facade;
    }

    @RequestMapping("/stores")
    public ModelAndView getStoresPage() {
        LOGGER.debug("Getting Stores page");
        return new ModelAndView("stores", "stores", facade.getAllStores());
    }

    @RequestMapping(value = "/store/create", method = RequestMethod.GET)
    public ModelAndView getAddStorePage() {
        LOGGER.debug("Getting Stores Add page");
        return new ModelAndView("store_create", "form", new StoreCreateForm());
    }

    @RequestMapping(value = "/store/create", method = RequestMethod.POST)
    public String  handleStoreCreateForm(@Valid @ModelAttribute("form") StoreCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing store create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            return "store_create";
        }

        final CurrentUser user = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        facade.create(form, user.getUser().getOrganization());

        return "redirect:/stores";
    }

}
