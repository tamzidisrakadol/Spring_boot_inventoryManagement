package com.example.Spring_boot_InventoryManager.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.Spring_boot_InventoryManager.Modal.Employee;
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


    //add Employee to desire category
    @PostMapping("/admin/addEmployee/{categoryId}")
    public String addEmployeeToCategoryList(@PathVariable("categoryId")int categroyId,
    @RequestParam("name") String name,
    @RequestParam("address")String address,
    @RequestParam("nid")String nid,
    @RequestParam("position")String position,
    @RequestParam("images")MultipartFile imgFile,
    @RequestParam("mobilenumber")Long mobilenumber
    ) throws IOException{

        EmployeeCategory employeeCategory = employeeService.findEmpCategory(categroyId);
        if(employeeCategory!=null){
            Employee employee = new Employee();
            Random radom  = new Random();
            int procductID =radom.nextInt((20000-1000)+1)+1000;
            employee.setEmployeeId(procductID);
            employee.setName(name);
            employee.setAddress(address);
            employee.setImmgurl(new Binary(BsonBinarySubType.BINARY, imgFile.getBytes()));
            employee.setNid(nid);
            employee.setPosition(position);
            employee.setMobileNumber(mobilenumber);
            employeeCategory.getEmployeeList().add(employee);
            employeeService.saveEmployee(employee);
            employeeService.saveEmployeeCategory(employeeCategory); 
            return "redirect:/admin/addEmployee";
        }else{
            return "admin/employee/addEmployee";
        }
    }
}
