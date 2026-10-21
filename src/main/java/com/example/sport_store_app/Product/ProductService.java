package com.example.sport_store_app.Product;

import com.example.sport_store_app.Product.dto.ProductDto;
import com.example.sport_store_app.category.dto.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductDtoMapper::toDto)
                .toList();
    }
}
