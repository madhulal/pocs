package com.mozanta.store.common.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mozanta.store.entity.Product;


public interface ProductRepository extends MongoRepository<Product, String> {
	public List<Product> findByProductCategory(String category);
	public List<Product> findByProductCategoryStartsWithIgnoreCase(String category);
	public List<Product> findByProductCategoryAndProductCompanyLikeAllIgnoringCase(String productCategory, String productCompany);
	public List<Product> findDistinctProductByProductNameLike(String value);
}
