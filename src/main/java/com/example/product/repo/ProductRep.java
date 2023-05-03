package com.example.product.repo;

import com.example.product.bean.Category;
import com.example.product.bean.Product;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface ProductRep extends JpaRepositoryImplementation<Product,Integer> {
    List <Product> findAllByCategory(Category category);
}
