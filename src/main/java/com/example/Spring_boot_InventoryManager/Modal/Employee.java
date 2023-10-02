package com.example.Spring_boot_InventoryManager.Modal;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "employee")
public class Employee {

    @Id
    String id;

    String name,nid,address,position;
    Long mobileNumber;
    Binary immgurl;
    
    public Employee() {
    }

    public Employee(String id, String name, String nid, String address, String position, Long mobileNumber,
            Binary immgurl) {
        this.id = id;
        this.name = name;
        this.nid = nid;
        this.address = address;
        this.position = position;
        this.mobileNumber = mobileNumber;
        this.immgurl = immgurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", nid=" + nid + ", address=" + address + ", position="
                + position + ", mobileNumber=" + mobileNumber + ", immgurl=" + immgurl + "]";
    }

    

    


    
    
    
}
