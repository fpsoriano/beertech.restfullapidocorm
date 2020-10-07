package com.beertech.restfullapidocorm.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.beertech.restfullapidocorm.controller.dto.ProductDto;
import com.beertech.restfullapidocorm.model.Product;
import com.beertech.restfullapidocorm.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getAllProduct() {
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable Long id) {
		Optional<Product> product = productService.findById(id);
		if(product.isPresent()) {
			return ResponseEntity.ok(product.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody ProductDto productDto, UriComponentsBuilder uriBuilder) {
		Product product = new Product(productDto);
		productService.saveOrUpdateProduct(product);
		
		URI uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(product);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProductName(@PathVariable Long id, @RequestBody Product product) {
		Optional<Product> optional = productService.findById(id);
		if (optional.isPresent()) {
			Product productToSave = optional.get();
			productToSave.setName(product.getName());
			productToSave.setDescription(product.getDescription());
			productToSave.setPrice(product.getPrice());
			productService.saveOrUpdateProduct(product);
			return ResponseEntity.ok(productToSave);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		Optional<Product> optional = productService.findById(id);
		if (optional.isPresent()) {
			productService.deleteProduct(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
