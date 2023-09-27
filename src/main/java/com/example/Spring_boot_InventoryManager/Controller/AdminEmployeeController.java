package com.example.Spring_boot_InventoryManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminEmployeeController {
    


    @GetMapping
    public String addEmployeeFormUI(){
        return "";
    }
}
