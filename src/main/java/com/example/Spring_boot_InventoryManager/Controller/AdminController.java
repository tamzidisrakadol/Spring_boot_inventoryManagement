package com.example.Spring_boot_InventoryManager.Controller;


import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    ProductService productService;

    @PostMapping("/admin/")
    public String saveProduct(@RequestBody Category category){
        return productService.saveProduct(category);
    }


    @PutMapping("/admin/updateProduct/{id}")
    public Category updateProduct(@RequestBody Category category, @PathVariable("id")int id){
        productService.updateProduct(category,id);
        return category;
    }


    @GetMapping("/admin/addProduct")
    public String addProductUi(){
        return "admin/addProduct";
    }
}
