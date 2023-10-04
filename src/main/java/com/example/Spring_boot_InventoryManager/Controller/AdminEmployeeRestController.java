package com.example.Spring_boot_InventoryManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring_boot_InventoryManager.Modal.EmployeeCategory;
import com.example.Spring_boot_InventoryManager.Service.EmployeeService;

@RestController
public class AdminEmployeeRestController {
    
    @Autowired
    EmployeeService employeeService;


    @GetMapping("/admin/rest/showAllEmpCategory")
    public List<EmployeeCategory> showallEmpCategory(){
        return employeeService.showEmployeeCategory();
    }
}
