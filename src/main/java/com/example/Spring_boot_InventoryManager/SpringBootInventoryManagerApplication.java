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
		ProductService productService = context.getBean(ProductService.class);
		Product product2 = new Product();
		product2.setId(851);
		product2.setDescription("Fresh  orange juice");
		product2.setName("Faanta");
		product2.setBatchNumber("asdasgsafgasdf");
		product2.setQuantity(30);
		product2.setImgUrl("asdjfnasdfjkl;n");
		product2.setExpireDate("12-09-23");

		Product product3 = new Product();
		product3.setId(552);
		product3.setDescription("Fresh Lichi juice");
		product3.setName("Lichi juice");
		product3.setBatchNumber("asdasdarvv");
		product3.setQuantity(15);
		product3.setImgUrl("sdfsadfn");
		product3.setExpireDate("10-09-23");

		List<Product> productList = new ArrayList<>();
		productList.add(product2);
		productList.add(product3);


		Category category1 = new Category();
		category1.setCategoryId(450);
		category1.setCategoryName("juice");
		category1.setProductList(productList);

		productService.saveProduct(product3);
		productService.saveCategory(category1);

	}

}
