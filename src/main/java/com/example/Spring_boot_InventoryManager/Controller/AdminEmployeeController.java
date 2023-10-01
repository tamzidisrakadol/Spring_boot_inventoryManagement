package com.example.Spring_boot_InventoryManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Spring_boot_InventoryManager.Modal.EmployeeCategory;
import com.example.Spring_boot_InventoryManager.Service.EmployeeService;

@Controller
public class AdminEmployeeController {

    @Autowired
    EmployeeService employeeService;

    // add employee html form
    @GetMapping("/admin/addEmployee")
    public String addEmployeeFormUI(Model model) {
        model.addAttribute("title", "Add Employee");
        List<EmployeeCategory> categoriyList = employeeService.showEmployeeCategory();
        model.addAttribute("categoriyList", categoriyList);
        return "admin/employee/addEmployee";
    }

    //  employee category html form
    @GetMapping("/admin/EmployeeCategory")
    public String EmployeeCategory(Model model) {
        model.addAttribute("title", "Create Categpry");
        EmployeeCategory employeeCategory = new EmployeeCategory();
        model.addAttribute("employeeCategory", employeeCategory);
        return "admin/employee/createEmployeeCategory";
    }

    //create employee category
    @PostMapping("/admin/createEmployeeCategory")
    public String createEmployeeCategory(@ModelAttribute("employeeCategory") EmployeeCategory employeeCategory) {
        employeeService.createEmployeeCategory(employeeCategory);
        return "redirect:/admin/addEmployee";
    }
}
