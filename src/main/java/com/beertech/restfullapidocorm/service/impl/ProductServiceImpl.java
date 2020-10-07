package com.beertech.restfullapidocorm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beertech.restfullapidocorm.model.Product;
import com.beertech.restfullapidocorm.repository.ProductRepository;
import com.beertech.restfullapidocorm.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public void saveOrUpdateProduct(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);		
	}

}
