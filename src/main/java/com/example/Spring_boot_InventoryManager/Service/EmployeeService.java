package com.example.Spring_boot_InventoryManager.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spring_boot_InventoryManager.Modal.Employee;
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


    public EmployeeCategory findEmpCategory(String categoryID){
        Optional<EmployeeCategory> employeeCategory = employeeCategoryRepo.findById(categoryID);
        return employeeCategory.orElse(null);
    }

    public String saveEmployee(Employee employee) throws IOException{
        employeeRepo.save(employee);
        return "success";
    }

    public String saveEmployeeCategory(EmployeeCategory employeeCategory){
        employeeCategoryRepo.save(employeeCategory);
        return "success";
    }

}
