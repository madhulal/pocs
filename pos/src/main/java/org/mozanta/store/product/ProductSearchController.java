package com.mozanta.store.product;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mozanta.store.common.repository.ProductRepository;
import com.mozanta.store.entity.Product;

@RestController
@Scope("singleton")
public class ProductSearchController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/ProductSearch/{category}", method = RequestMethod.GET, produces = "application/json")
	public List<Product> searchProductCategory(@PathVariable final String category) {
		return productRepository.findByProductCategoryStartsWithIgnoreCase(category);
	}
	

	@RequestMapping(value = "/Categories", method = RequestMethod.GET, consumes = "application/json")
	public List<String> getProductCategory() {
		
		List<String>varList=productService.getProductCategoryList();
		return  varList;
	}
	
	@RequestMapping(value = "/ProductList", method = RequestMethod.GET, consumes = "application/json")
	public List<Product> getProducList() {
		List<Product>varList=productRepository.findDistinctProductByProductNameLike("");
		return  varList;
	}
}

