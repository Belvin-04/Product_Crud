package com.example.product.repo;

import com.example.product.bean.Category;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface CategoryRep extends JpaRepositoryImplementation<Category,Integer> {
}
