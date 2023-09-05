package com.example.Spring_boot_InventoryManager.Modal;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "Images")
public class Image {
    
    @Id
    private int id;

    private String title;

    private Binary images;

    public Image() {
    }

    public Image(int id, String title, Binary images) {
        this.id = id;
        this.title = title;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Binary getImages() {
        return images;
    }

    public void setImages(Binary images) {
        this.images = images;
    }

    
}
