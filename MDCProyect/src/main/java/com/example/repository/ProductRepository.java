package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Product;

public interface ProductRepository  extends JpaRepository<Product, Long> {

    @Query("Select p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findByNameContaining(@Param("name") String name);
}
