package com.example.Spring_boot_InventoryManager.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Spring_boot_InventoryManager.Modal.EmployeeCategory;

@Repository
public interface EmployeeCategoryRepo extends MongoRepository<EmployeeCategory,String>{
    
}
