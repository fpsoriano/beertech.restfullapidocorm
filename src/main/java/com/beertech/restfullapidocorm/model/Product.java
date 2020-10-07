package com.beertech.restfullapidocorm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.beertech.restfullapidocorm.controller.dto.ProductDto;

@Entity
public class Product {

	@GeneratedValue
	@Id
	private Long id;
	private String name;
	private String description;
	private Double price;
	
	public Product() {
	}
		
	public Product(ProductDto productDto) {
		this.name = productDto.getName();
		this.description = productDto.getDescription();
		this.price = productDto.getPrice();
	}
	
	public Product(String name, String description, Double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
