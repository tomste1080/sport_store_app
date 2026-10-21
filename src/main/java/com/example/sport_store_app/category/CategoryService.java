package com.example.sport_store_app.category;

import com.example.sport_store_app.category.dto.CategoryDto;
import com.example.sport_store_app.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDtoMapper::toDto)
                .toList();
    }

    public CategoryDto getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryDtoMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + id + " not found"));
    }

    @Transactional
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryDtoMapper.toEntity(categoryDto);
        Category categoryToSave = categoryRepository.save(category);
        return CategoryDtoMapper.toDto(categoryToSave);
    }

    @Transactional
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cateogry with id: " + id + " not found");
        }
        categoryRepository.deleteById(id);
    }
}
