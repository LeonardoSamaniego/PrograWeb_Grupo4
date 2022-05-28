package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.entities.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductoService {
	
	private ProductRepository productRepository;

	public ProductoService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product insert(Product product) {
		this.productRepository.save(product);
		return product;
	}

	public Product update(Product product) {
		this.productRepository.save(product);
		return product;
	}
	
	public Product getById(Long id) {
		Product product = this.productRepository.findById(id).get();
		return product;
	}

	public void delete(Long id){
		this.productRepository.deleteById(id);
	}

	public List<Product> findAll(){
		return this.productRepository.findAll();
	}

	public List<Product> findByName(String name){
		return this.productRepository.findByNameContaining(name);
	}
}
