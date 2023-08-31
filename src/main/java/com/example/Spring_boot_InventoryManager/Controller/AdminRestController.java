package com.example.Spring_boot_InventoryManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Repository.CategoryRepo;
import com.example.Spring_boot_InventoryManager.Service.ProductService;

@RestController
public class AdminRestController {
    

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping("/admin/showAll")
    public List<Category> showProduct() {
        return productService.showCategory();
    }
}
