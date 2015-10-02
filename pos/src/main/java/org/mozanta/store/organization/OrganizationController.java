package com.mozanta.store.organization;

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

import com.mozanta.store.entity.Organization;

@RestController
@Scope("singleton")
public class OrganizationController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	


	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping(value = "/Organization", method = RequestMethod.POST, consumes = "application/json")
	public void addOrganization(@RequestBody Organization organization,
			final BindingResult result, final ModelMap model) {
	
		organizationService.registerOrganization(organization);;

	}

}
