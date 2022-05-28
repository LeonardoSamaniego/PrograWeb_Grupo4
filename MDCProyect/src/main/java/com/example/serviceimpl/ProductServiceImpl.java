package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductoService;

@Service
public class ProductServiceImpl implements ProductoService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product insert(Product product) {
		this.productRepository.save(product);
		return product;
	}

	@Override
	public Product update(Product product) {
		this.productRepository.save(product);
		return product;
	}
	
	@Override
	public Product getById(Long id) {
		Product product = this.productRepository.findById(id).get();
		return product;
	}

	@Override
	public void delete(Long id){
		this.productRepository.deleteById(id);
	}

	@Override
	public List<Product> findAll(){
		return this.productRepository.findAll();
	}

	@Override
	public List<Product> findByName(String name){
		return this.productRepository.findByNameContainingIgnoreCase(name);
	}
}
