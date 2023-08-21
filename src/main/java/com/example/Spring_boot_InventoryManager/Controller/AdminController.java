package com.example.Spring_boot_InventoryManager.Controller;


import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Modal.Product;
import com.example.Spring_boot_InventoryManager.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    ProductService productService;




//    @GetMapping("/admin/addProduct")
//    public String addProductUi(){
//        return "admin/addProduct";
//    }
}
