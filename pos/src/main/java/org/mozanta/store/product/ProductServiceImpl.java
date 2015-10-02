package com.mozanta.store.product;

import java.util.ArrayList;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozanta.store.common.model.ProductModel;
import com.mozanta.store.common.repository.ProductRepository;
import com.mozanta.store.entity.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void registerProduct(ProductModel productModel) {
		
		Product product=new Product();
		product.setProductCategory(productModel.getProductCategory());
		product.setProductCompany(productModel.getProductCompany());
		product.setProductName(productModel.getProductName());
		productRepository.save(product);
		
		  
	}

	@Override
	public List<String> getProductCategoryList() {
		List<String> productcategoryList = new ArrayList<String>();
		List<Product> productmodelList = productRepository.findAll();
		logger.debug("value list is ==>"
				+ productmodelList.get(1).getProductCategory());
		for (int i = 0; i < productmodelList.size(); i++) {
			
			if (!productcategoryList.contains(productmodelList.get(i)
					.getProductCategory())) {
				productcategoryList.add(productmodelList.get(i)
						.getProductCategory());
			}
		}

		return productcategoryList;
	}

	@Override
	public List<String> getOrganizationList() {
		// TODO Auto-generated method stub
		return null;
	}

}
