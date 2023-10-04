package com.example.Spring_boot_InventoryManager.Modal;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "employee")
public class Employee {
    @Id
    int productId;

    String name, nid, address, position;
    Long mobileNumber;
    Binary immgurl;

    public Employee() {

    }

    public Employee(int productId, String name, String nid, String address, String position, Long mobileNumber, Binary immgurl) {
        this.productId = productId;
        this.name = name;
        this.nid = nid;
        this.address = address;
        this.position = position;
        this.mobileNumber = mobileNumber;
        this.immgurl = immgurl;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Binary getImmgurl() {
        return immgurl;
    }

    public void setImmgurl(Binary immgurl) {
        this.immgurl = immgurl;
    }
}
