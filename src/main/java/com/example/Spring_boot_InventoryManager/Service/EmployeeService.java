package com.example.Spring_boot_InventoryManager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spring_boot_InventoryManager.Modal.EmployeeCategory;
import com.example.Spring_boot_InventoryManager.Repository.EmployeeCategoryRepo;
import com.example.Spring_boot_InventoryManager.Repository.EmployeeRepo;


@Service
public class EmployeeService {
    

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    EmployeeCategoryRepo employeeCategoryRepo;


    public String  createEmployeeCategory(EmployeeCategory employeeCategory){
        employeeCategoryRepo.save(employeeCategory);
        return "success";
    }


    public List<EmployeeCategory> showEmployeeCategory(){
        return employeeCategoryRepo.findAll();
    }

}
