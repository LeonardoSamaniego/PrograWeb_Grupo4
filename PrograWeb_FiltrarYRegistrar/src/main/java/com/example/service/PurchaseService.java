package com.example.service;

import java.util.List;

import com.example.entities.Purchase;

public interface PurchaseService {

	void insert(Purchase purchase) throws Exception;

	Purchase findById(long id) throws Exception;

	List<Purchase> findByUserId(long id) throws Exception;

}
