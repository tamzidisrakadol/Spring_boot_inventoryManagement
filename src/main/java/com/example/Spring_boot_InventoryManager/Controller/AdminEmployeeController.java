package com.example.Spring_boot_InventoryManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminEmployeeController {
    

    //add employee html form 
    @GetMapping("/admin/addEmployee")
    public String addEmployeeFormUI(Model model){
        model.addAttribute("title", "Add Employee");
        return "admin/employee/addEmployee";
    }


    //create employee category html form
    @GetMapping("/admin/EmployeeCategory")
    public String EmployeeCategory(Model model){
        model.addAttribute("title", "Create Categpry");
        return "admin/employee/createEmployeeCategory";
    }
}
