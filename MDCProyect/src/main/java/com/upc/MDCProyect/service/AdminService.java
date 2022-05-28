package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.entities.Product;
import com.example.repository.ProductRepository;

public class AdminService {

	private ProductRepository productRepository;
	private Product productEntities;

	public AdminService(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}
	
	public Product updateProducts(Product product) {
		this.productRepository.save(product);
		return product;
	}

}
