package com.example.Spring_boot_InventoryManager.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Spring_boot_InventoryManager.Modal.Image;

@Repository
public interface ImageRepo extends MongoRepository<Image,Integer>{
    
}
