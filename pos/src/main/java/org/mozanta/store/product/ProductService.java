package com.mozanta.store.product;

import java.util.*;

import com.mozanta.store.common.model.ProductModel;

public interface ProductService {

	void registerProduct(final ProductModel productModel);
	List<String>getProductCategoryList();
	List<String>getOrganizationList();
	
	
}
