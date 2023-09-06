package com.example.Spring_boot_InventoryManager.Service;

import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Modal.Image;
import com.example.Spring_boot_InventoryManager.Modal.Product;
import com.example.Spring_boot_InventoryManager.Repository.CategoryRepo;
import com.example.Spring_boot_InventoryManager.Repository.ImageRepo;
import com.example.Spring_boot_InventoryManager.Repository.ProductRepo;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProductService {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ImageRepo imageRepo;

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

        public String addPhoto(MultipartFile file)throws IOException {
        Image image = new Image();
        Random random = new Random();
        int imgRandom = random.nextInt(50);
        image.setId(imgRandom);
        image.setTitle(file.getOriginalFilename());
        image.setImages(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        imageRepo.save(image);
        return "success";
    }


    public Product getProduct(int id){
        return productRepo.findById(id).get();
    }
    

}
