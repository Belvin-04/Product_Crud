package com.example.product.controller;

import com.example.product.bean.Category;
import com.example.product.repo.CategoryRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRep categoryRep;
    @GetMapping("/categories")
    public List<Category> getAllCategories(){return categoryRep.findAll();}

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable int id){return categoryRep.findById(id).get();}

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category){return categoryRep.save(category);}

    @PutMapping("/category")
    public Category updateCategory(@RequestBody Category category){
        Category c = categoryRep.findById(category.getId()).get();
        c.setCategory(category.getCategory());
        return categoryRep.save(c);
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable int id){
        categoryRep.deleteById(id);
        return "{\"msg\":\"Delete Successfully...\"}";
    }
}
