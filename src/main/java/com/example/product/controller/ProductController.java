package com.example.product.controller;

import com.example.product.bean.Category;
import com.example.product.bean.Product;
import com.example.product.repo.CategoryRep;
import com.example.product.repo.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRep productRep;
    @Autowired
    private CategoryRep categoryRep;

    @GetMapping("/products")
    public List<Product> getAllProducts(){return productRep.findAll();}

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id){return productRep.findById(id).get();}

    @GetMapping("/{id}/products")
    public List<Product> getAllProductsInCategory(@PathVariable int id){
        Category c = categoryRep.findById(id).get();
        return productRep.findAllByCategory(c);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){return productRep.save(product);}

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        Product p = productRep.findById(product.getId()).get();
        p.setCategory(product.getCategory());
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        return productRep.save(p);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id){productRep.deleteById(id);
        return "{\"msg\":\"Delete Successfully...\"}";
    }

}
