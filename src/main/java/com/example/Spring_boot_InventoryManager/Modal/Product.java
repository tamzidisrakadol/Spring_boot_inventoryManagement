package com.example.Spring_boot_InventoryManager.Modal;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//change quantity to int , add price

@Document(collection = "Products")
public class Product {
    @Id
    int id;
    String name;
    String description;
    int quantity;
    int price;
    String expireDate;
    Binary images;
    String imageName;
    String batchNumber;

    public Product() {
    }

    public Product(int id, String name, String description, int quantity, int price, String expireDate, Binary images,
            String imageName, String batchNumber) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.expireDate = expireDate;
        this.images = images;
        this.imageName = imageName;
        this.batchNumber = batchNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public Binary getImages() {
        return images;
    }

    public void setImages(Binary images) {
        this.images = images;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    


}
