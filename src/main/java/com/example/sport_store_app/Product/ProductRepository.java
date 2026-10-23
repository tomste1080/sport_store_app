package com.example.sport_store_app.Product;

import com.example.sport_store_app.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    List<Product> findByCategory_Id(Long categoryId);
}
