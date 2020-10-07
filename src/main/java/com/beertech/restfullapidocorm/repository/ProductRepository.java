package com.beertech.restfullapidocorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beertech.restfullapidocorm.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
