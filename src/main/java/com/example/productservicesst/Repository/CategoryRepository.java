package com.example.productservicesst.Repository;

import com.example.productservicesst.Models.Category;
import com.example.productservicesst.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Override
    Category save (Category category);
}
