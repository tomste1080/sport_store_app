package com.example.sport_store_app.Product.dto;

import com.example.sport_store_app.category.dto.CategoryDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private String brand;
    @Positive(message = "Price must be greater than zero")
    @NotNull
    private BigDecimal price;
    @NotNull
    @Min(0)
    private Integer quantity;
    private String imageUrl;
    private CategoryDto categoryDto;
}
