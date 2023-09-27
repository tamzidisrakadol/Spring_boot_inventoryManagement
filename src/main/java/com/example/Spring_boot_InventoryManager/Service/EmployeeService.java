package com.example.Spring_boot_InventoryManager.Service;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.Spring_boot_InventoryManager.Repository.EmployeeCategoryRepo;
import com.example.Spring_boot_InventoryManager.Repository.EmployeeRepo;

public class EmployeeService {
    

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    EmployeeCategoryRepo employeeCategoryRepo;

}
