package com.example.sport_store_app.category;

import com.example.sport_store_app.category.dto.CategoryDto;

public class CategoryDtoMapper {
    public static CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setSlug(category.getSlug());
        return categoryDto;
    }

    public static Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setSlug(categoryDto.getSlug());
        return category;
    }
}
