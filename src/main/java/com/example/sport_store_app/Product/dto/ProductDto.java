package com.example.sport_store_app.Product.dto;

import com.example.sport_store_app.category.dto.CategoryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private Integer quantity;
    private String imageUrl;
    private CategoryDto categoryDto;
}
