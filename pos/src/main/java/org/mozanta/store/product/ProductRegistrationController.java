package com.mozanta.store.product;

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

import com.mozanta.store.common.model.ProductModel;

@RestController
@Scope("singleton")
public class ProductRegistrationController {

	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/Product", method = RequestMethod.POST, consumes = "application/json")
	public void addProduct(@RequestBody ProductModel productModel,
			final BindingResult result, final ModelMap model) {

		
		productService.registerProduct(productModel);

	}

}
