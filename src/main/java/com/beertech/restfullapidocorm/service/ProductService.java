package com.beertech.restfullapidocorm.service;

import java.util.List;
import java.util.Optional;

import com.beertech.restfullapidocorm.model.Product;

public interface ProductService {

	List<Product> findAll();
	Optional<Product> findById(Long id);
	void saveOrUpdateProduct(Product product);
	void deleteProduct(Long id);	

}
