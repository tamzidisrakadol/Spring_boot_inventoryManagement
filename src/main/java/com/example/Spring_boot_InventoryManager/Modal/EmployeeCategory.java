package com.example.Spring_boot_InventoryManager.Modal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employeeCategory")
public class EmployeeCategory {
    
    String categoryId, categoryName;

    @DBRef
    List<Employee> employeeList = new ArrayList<>();

    

    public EmployeeCategory() {
    }



    public EmployeeCategory(String categoryId, String categoryName, List<Employee> employeeList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.employeeList = employeeList;
    }



    public String getCategoryId() {
        return categoryId;
    }



    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }



    public String getCategoryName() {
        return categoryName;
    }



    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }



    public List<Employee> getEmployeeList() {
        return employeeList;
    }



    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    
    
}
