package com.example.Spring_boot_InventoryManager.Controller;

import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Modal.Product;
import com.example.Spring_boot_InventoryManager.Repository.CategoryRepo;
import com.example.Spring_boot_InventoryManager.Repository.ProductRepo;
import com.example.Spring_boot_InventoryManager.Service.ProductService;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
public class AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;

    // adding product html form
    @GetMapping("admin/addProduct")
    public String addProductui(Model model) {
        model.addAttribute("title", "Add product");
        Product product = new Product();
        List<Category> categoryList = productService.showCategory();
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryList);
        return "admin/addProduct";

    }

    // create category
    @PostMapping("/admin/createCategory")
    public String createCategory(@ModelAttribute("category") Category category) {
        Random random = new Random();
        int categoryRandomId = random.nextInt(50);
        category.setCategoryId(categoryRandomId);
        Category result = categoryRepo.save(category);
        System.out.println(result);
        return "redirect:/admin/addProduct";
    }

    // add product to desire category
    @PostMapping("/admin/update/{categoryId}")
    public String updateCategoryList(@PathVariable("categoryId") int categoryId,
            @RequestParam("images") MultipartFile imageFile,
            @RequestParam("name") String name,
            @RequestParam("batchnumber") String batchNumber,
            @RequestParam("description") String description,
            @RequestParam("expireDate") String expireDate,
            @RequestParam("quantity") int quantity,
            Model model)
            throws IOException {

        Category category = productService.findByCategory(categoryId);

        if (category != null) {
            Random random = new Random();
            int productRandomID = random.nextInt(150);
            Product product = new Product();
            product.setId(productRandomID);
            product.setName(name);
            product.setBatchNumber(batchNumber);
            product.setDescription(description);
            product.setExpireDate(expireDate);
            product.setQuantity(quantity);
            product.setImageName(imageFile.getOriginalFilename());
            product.setImages(new Binary(BsonBinarySubType.BINARY, imageFile.getBytes()));
            category.getProductList().add(product);
            productService.saveProduct(product);
            productService.saveCategory(category);
            return "redirect:/admin/addProduct";
        } else {
            return "admin/addproduct";
        }

    }

    // creating category ui
    @GetMapping("/admin/category")
    public String createCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/createCategory";
    }



}
