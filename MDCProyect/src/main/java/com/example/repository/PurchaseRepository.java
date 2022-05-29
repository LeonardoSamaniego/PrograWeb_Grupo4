package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entities.Purchase;

public interface PurchaseRepository  extends JpaRepository<Purchase, Long> {

}
