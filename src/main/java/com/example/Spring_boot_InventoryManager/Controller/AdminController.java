package com.example.Spring_boot_InventoryManager.Controller;

import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Modal.Product;
import com.example.Spring_boot_InventoryManager.Repository.CategoryRepo;
import com.example.Spring_boot_InventoryManager.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
public class AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping("/admin/showAll")
    public List<Category> showProduct() {
        return productService.showCategory();
    }

    @GetMapping("admin/addProduct")
    public String addProductui(Model model) {
        model.addAttribute("title", "Add product");
        Category category = new Category();
        List<Category> categoryList = productService.showCategory();
        model.addAttribute("category", category);
        model.addAttribute("categoryList", categoryList);
        return "admin/addProduct";
    }

    @PostMapping("/admin/createCategory")
    public String createCategory(@ModelAttribute("category") Category category) {
        Random random = new Random();
        int categoryRandomId = random.nextInt(50);
        category.setCategoryId(categoryRandomId);
        Category result = categoryRepo.save(category);
        System.out.println(result);
        return "admin/addproduct";
    }

    @PutMapping("/admin/update/{categoryId}")
    public String updateCategoryList(@PathVariable("categoryId") int categoryId,@RequestBody Product product){
        System.out.println(categoryId);
        Category category = productService.findByCategory(categoryId);
        if (category!=null){
            category.getProductList().add(product);
            productService.saveProduct(product);
            productService.saveCategory(category);
            return "admin/addproduct";
        }else{
            return "admin/addproduct";
        }
        
    }

    // to update the list
    // @PutMapping("/admin/update/{id}")
    // public String updateCategory(@PathVariable int id, @RequestBody Product
    // product){
    // Category category = productService.findByCategory(id);
    // if (category!=null){
    // category.getProductList().add(product);
    // productService.saveProduct(product);
    // return productService.saveCategory(category);
    // }else{
    // return null;
    // }

    // }

}
