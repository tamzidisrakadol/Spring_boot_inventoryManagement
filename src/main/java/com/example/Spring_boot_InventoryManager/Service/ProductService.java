package com.example.Spring_boot_InventoryManager.Service;


import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public String saveProduct(@RequestBody Category category){
        productRepo.save(category);
        return "Success";
    }
}
