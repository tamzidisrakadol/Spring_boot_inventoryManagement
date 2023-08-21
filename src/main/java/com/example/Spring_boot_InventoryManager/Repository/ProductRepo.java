package com.example.Spring_boot_InventoryManager.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Spring_boot_InventoryManager.Modal.Product;

public interface ProductRepo extends MongoRepository<Product, Integer> {


}
