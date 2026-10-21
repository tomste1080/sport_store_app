package com.example.sport_store_app.Product;

import com.example.sport_store_app.Product.dto.ProductDto;
import com.example.sport_store_app.category.CategoryDtoMapper;

public class ProductDtoMapper {
    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setBrand(product.getBrand());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setCategoryDto(CategoryDtoMapper.toDto(product.getCategory()));
        return productDto;
    }

    public static Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setBrand(productDto.getBrand());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setImageUrl(productDto.getImageUrl());
        product.setCategory(CategoryDtoMapper.toEntity(productDto.getCategoryDto()));
        return product;
    }
}
