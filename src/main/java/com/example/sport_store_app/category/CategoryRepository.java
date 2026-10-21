package com.example.sport_store_app.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    List<Category> findAll();

    @Override
    Optional<Category> findById(Long aLong);

}
