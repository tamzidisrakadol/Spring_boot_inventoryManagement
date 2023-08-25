package com.example.Spring_boot_InventoryManager.Controller;


import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Modal.Product;
import com.example.Spring_boot_InventoryManager.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    ProductService productService;


    @GetMapping("/admin/showAll")
    public List<Category> showProduct(){
        return productService.showCategory();
    }


    @GetMapping("admin/addProduct")
    public String addProductui(){
        return "admin/addProduct";
    }





    //to update  the list 
    // @PutMapping("/admin/update/{id}")
    // public String updateCategory(@PathVariable int id, @RequestBody Product product){
    //     Category category = productService.findByCategory(id);
    //     if (category!=null){
    //         category.getProductList().add(product);
    //         productService.saveProduct(product);
    //         return productService.saveCategory(category);
    //     }else{
    //         return null;
    //     }

    // }


//    @GetMapping("/admin/addProduct")
//    public String addProductUi(){
//        return "admin/addProduct";
//    }
}
