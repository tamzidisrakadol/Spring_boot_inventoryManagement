package com.example.Spring_boot_InventoryManager.Modal;
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
    String expireDate;
    String imgUrl;
    String batchNumber;

    public Product() {
    }

    public Product(int id, String name, String description, int quantity, String expireDate, String imgUrl, String batchNumber) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.expireDate = expireDate;
        this.imgUrl = imgUrl;
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

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", expireDate='" + expireDate + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                '}';
    }
}
