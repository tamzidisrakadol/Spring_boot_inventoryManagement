package com.example.Spring_boot_InventoryManager;

import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Modal.Product;
import com.example.Spring_boot_InventoryManager.Service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootInventoryManagerApplication {

	public static void main(String[] args) {
	ApplicationContext context= SpringApplication.run(SpringBootInventoryManagerApplication.class, args);
		

	}

}
