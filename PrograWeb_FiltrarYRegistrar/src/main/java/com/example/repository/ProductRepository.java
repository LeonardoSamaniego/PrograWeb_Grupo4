package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

    public List<Product> findByNameContainingIgnoreCase(String name);
    
    @Query("Select p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findByNameContaining(@Param("name") String name);

    @Query("Select p FROM Product p WHERE p.category LIKE :category")
    public List<Product> findByCategoryContaining(@Param("category") String category);

}
