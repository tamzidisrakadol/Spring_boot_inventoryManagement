package com.example.Spring_boot_InventoryManager.Service;

import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Modal.Product;
import com.example.Spring_boot_InventoryManager.Repository.CategoryRepo;
import com.example.Spring_boot_InventoryManager.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;


    public String saveProduct(Product product) throws IOException {
        productRepo.save(product);
        return "Success";
    }

    public String saveCategory(Category category) {
        categoryRepo.save(category);
        return "success";
    }

    public List<Category> showCategory() {
        return categoryRepo.findAll();
    }

    public Category findByCategory(int id) {
        Optional<Category> getCategory = categoryRepo.findById(id);
        return getCategory.orElse(null);
    }



    public Product getProduct(int id){
        return productRepo.findById(id).get();
    }
    

}
