package com.example.Spring_boot_InventoryManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminEmployeeController {
    


    @GetMapping("/admin/addEmployee")
    public String addEmployeeFormUI(Model model){
        model.addAttribute("title", "Add Employee");
        return "admin/employee/addEmployee";
    }
}
