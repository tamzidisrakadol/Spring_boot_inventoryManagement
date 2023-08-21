package com.example.Spring_boot_InventoryManager.Repository;


import com.example.Spring_boot_InventoryManager.Modal.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends MongoRepository<Category,Integer>{

}
