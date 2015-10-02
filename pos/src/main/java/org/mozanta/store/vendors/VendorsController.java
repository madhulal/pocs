package com.mozanta.store.vendors;

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

import com.mozanta.store.entity.Vendors;


@RestController
@Scope("singleton")
public class VendorsController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	VendorsService vendorsService;
	
	@RequestMapping(value = "/Vendors", method = RequestMethod.POST, consumes = "application/json")
	public void addProduct(@RequestBody Vendors vendors,
			final BindingResult result, final ModelMap model) {
		vendorsService.registerVendors(vendors);
		
	
	}
	

}
