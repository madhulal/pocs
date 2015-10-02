package com.mozanta.store.manufactures;

import java.util.ArrayList;
import java.util.List;

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

import com.mozanta.store.entity.Manufactures;
import com.mozanta.store.organization.OrganizationService;


@RestController
@Scope("singleton")
public class ManufacturesController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ManufacturesService manufacturesService;
	
	@Autowired
	OrganizationService organizationService;
	
	@RequestMapping(value = "/Manufactures", method = RequestMethod.POST, consumes = "application/json")
	public void addManufactures(@RequestBody Manufactures manufactures,
			final BindingResult result, final ModelMap model) {
		List<Manufactures> userList = new ArrayList<Manufactures>();
		manufacturesService.registerManufactures(manufactures);

	
	}

}
