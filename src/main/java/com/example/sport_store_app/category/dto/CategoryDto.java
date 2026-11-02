package com.example.sport_store_app.category.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String slug;
}
