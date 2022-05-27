package com.example.service;

import java.util.List;

import com.example.entities.Product;

public interface ProductoService {

	Product insert(Product product);

	Product update(Product product);

	Product getById(Long id);

	List<Product> findAll();

	void delete(Long id);

	List<Product> findByName(String name);
	

}
