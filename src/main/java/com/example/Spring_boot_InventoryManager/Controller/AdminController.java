package com.example.Spring_boot_InventoryManager.Controller;

import com.example.Spring_boot_InventoryManager.Config.WebConfig;
import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Modal.Product;
import com.example.Spring_boot_InventoryManager.Repository.CategoryRepo;
import com.example.Spring_boot_InventoryManager.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepo categoryRepo;


    // adding product html form
    @GetMapping("admin/addProduct")
    public String addProductui(Model model) {
        model.addAttribute("title", "Add product");
        Category category = new Category();
        Product product = new Product();
        List<Category> categoryList = productService.showCategory();
        model.addAttribute("category", category);
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
            @ModelAttribute("product") Product product, @RequestParam("image") MultipartFile imageFile) {

        System.out.println(categoryId);
        Category category = productService.findByCategory(categoryId);
        if (category != null) {
            Random random = new Random();
            int productRandomID = random.nextInt(150);
            String imgurl = saveImage(imageFile);
            product.setImgUrl(imgurl);
            product.setId(productRandomID);
            category.getProductList().add(product);
            productService.saveProduct(product);
            productService.saveCategory(category);
            return "redirect:/admin/addProduct";
        } else {
            return "admin/addproduct";
        }

    }

    private String saveImage(MultipartFile imageFile) {

        String uploadDirectory = "static/image";

        String uniqueFileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();

        try {
            var directory = new File(uploadDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filePath = uploadDirectory + uniqueFileName;
            Files.write(Paths.get(filePath), imageFile.getBytes());
            String imageUrl = "http://localhost:8080"+"/images/"+uniqueFileName;

            return imageUrl;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        
    }

}
