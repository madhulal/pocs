package com.mozanta.store.purchase;

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
import com.mozanta.store.entity.Purchase;


@RestController
@Scope("singleton")
public class PurchaseController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PurchaseService purchaseService;
	
	@RequestMapping(value = "/Purchase", method = RequestMethod.POST, consumes = "application/json")
	public void addManufactures(@RequestBody Purchase purchase,
			final BindingResult result, final ModelMap model) {
	
		System.out.println("haiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		purchaseService.productPurchase(purchase);
	
	}

}
