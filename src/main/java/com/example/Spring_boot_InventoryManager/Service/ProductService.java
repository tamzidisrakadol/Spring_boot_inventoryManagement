package com.example.Spring_boot_InventoryManager.Service;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import com.example.Spring_boot_InventoryManager.Modal.Category;
import com.example.Spring_boot_InventoryManager.Modal.Product;
import com.example.Spring_boot_InventoryManager.Repository.CategoryRepo;
import com.example.Spring_boot_InventoryManager.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;

 
    public String saveProduct(Product product) throws IOException {
        productRepo.save(product);
        return "Success";
    }

    public String saveCategory(Category category) {
        categoryRepo.save(category);
        return "success";
    }

    public List<Category> showCategory() {
        return categoryRepo.findAll();
    }

    public Category findByCategory(int id) {
        Optional<Category> getCategory = categoryRepo.findById(id);
        return getCategory.orElse(null);
    }



    public Product getProduct(int id){
        return productRepo.findById(id).get();
    }

    public List<Product> showAllProduct(){
        return productRepo.findAll();
    }


    public Product getProductInfo(int id ){
        Optional<Product> getProduct = productRepo.findById(id);
        return getProduct.orElse(null);
    }


    // public Category findCategoryByProductName(String productName) {
    //     // Create an aggregation query to join 'Category' and 'Product' collections
    //     LookupOperation lookup = LookupOperation.newLookup()
    //             .from("Products") // Name of the target collection
    //             .localField("productList") // Field in 'Category' collection
    //             .foreignField("_id") // Field in 'Product' collection
    //             .as("products");

    //     // Match the 'Product' with the specified name
    //     Criteria matchCriteria = Criteria.where("products.name").is(productName);

    //     // Create the aggregation pipeline
    //     Aggregation aggregation = Aggregation.newAggregation(
    //             lookup,
    //             Aggregation.match(matchCriteria)
    //     );

    //     // Execute the aggregation query
    //     Category category = mongoTemplate.aggregate(aggregation, "Category", Category.class)
    //             .getUniqueMappedResult();

    //     return category;
    // }
    

}
