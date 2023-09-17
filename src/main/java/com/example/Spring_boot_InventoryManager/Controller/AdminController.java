package com.example.Spring_boot_InventoryManager.Controller;

import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Modal.Product;
import com.example.Spring_boot_InventoryManager.Modal.ProductInfo;
import com.example.Spring_boot_InventoryManager.Repository.CategoryRepo;
import com.example.Spring_boot_InventoryManager.Repository.ProductRepo;
import com.example.Spring_boot_InventoryManager.Service.ProductService;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
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

    @Autowired
    MongoTemplate mongoTemplate;

    // adding product html-form
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
            @RequestParam("price") int price,
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
            product.setPrice(price);
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

    // showing all product
    @GetMapping("/admin/showProduct")
    public String showProductUI(Model model) {
        model.addAttribute("title", "Show Product");
        List<Product> showAllProduct = productService.showAllProduct();

        List<ProductInfo> newProductslist = new ArrayList<>();
        for (Product product : showAllProduct) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setName(product.getName());
            productInfo.setImgUrl(Base64.getEncoder().encodeToString(product.getImages().getData()));
            productInfo.setPrice(product.getPrice());
            newProductslist.add(productInfo);
        }
        model.addAttribute("newProductslist", newProductslist);
        return "admin/showProduct";
    }

    // showing all category
    @GetMapping("/admin/getCategoryList")
    public String getCategoryList(Model model) {
        model.addAttribute("title", "Category List");
        List<Category> categories = productService.showCategory();
        model.addAttribute("categories", categories);
        return "admin/getCategorylist";
    }

    @GetMapping("/admin/{categoryName}")
    public String getCategoryByProductName(@PathVariable("categoryName") String categoryName, Model model) {
        Query query = new Query();
        query.addCriteria(Criteria.where("categoryName").is(categoryName));
        List<Category> categoriyList = mongoTemplate.find(query, Category.class);
        List<Product> productList = categoriyList.get(0).getProductList();
        model.addAttribute("productList",productList);
        return "admin/showProductbyCategory";
    }

}

// List<Product> matchingProducts = new ArrayList<>();
// for (Category category : categoriyList) {
// // Iterate through the productList of each Category
// for (Product product : category.getProductList()) {
// // Check if the product name matches the provided name
// if (product.getName().equals("Capcisum")) {
// // Add the matching product to the list
// matchingProducts.add(product);
// }
// }

// String batchNumber = matchingProducts.get(0).getBatchNumber();
// model.addAttribute("batchNumber", batchNumber);
// }
