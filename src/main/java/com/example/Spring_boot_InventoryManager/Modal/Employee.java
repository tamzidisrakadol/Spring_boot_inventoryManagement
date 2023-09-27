package com.example.Spring_boot_InventoryManager.Modal;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {

    String id,name,imgurl,nid,address,position;
    Long mobileNumber;

    
    public Employee() {
    }


    public Employee(String id, String name, String imgurl, String nid, String address, String position,
            Long mobileNumber) {
        this.id = id;
        this.name = name;
        this.imgurl = imgurl;
        this.nid = nid;
        this.address = address;
        this.position = position;
        this.mobileNumber = mobileNumber;
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


    public String getImgurl() {
        return imgurl;
    }


    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
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


    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", imgurl=" + imgurl + ", nid=" + nid + ", address=" + address
                + ", position=" + position + ", mobileNumber=" + mobileNumber + "]";
    }
    
    
}
