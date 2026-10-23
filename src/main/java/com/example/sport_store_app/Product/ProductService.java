package com.example.sport_store_app.Product;

import com.example.sport_store_app.Product.dto.ProductDto;
import com.example.sport_store_app.category.Category;
import com.example.sport_store_app.category.CategoryRepository;
import com.example.sport_store_app.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductDtoMapper::toDto)
                .toList();
    }

    public ProductDto getProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductDtoMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " not found"));
    }

    public List<ProductDto> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategory_Id(categoryId)
                .stream()
                .map(ProductDtoMapper::toDto)
                .toList();
    }

    @Transactional
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductDtoMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductDtoMapper.toDto(savedProduct);
    }

    @Transactional
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id:" + id + "not found"));
        if (productDto.getCategoryDto() != null && productDto.getCategoryDto().getId() != null) {
            Long categoryId = productDto.getId();
            Category category = categoryRepository.findById(productDto.getCategoryDto().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Cateogry with id:" + categoryId + "not found"));
            product.setCategory(category);
        }
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setBrand(productDto.getBrand());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setImageUrl(productDto.getImageUrl());
        return ProductDtoMapper.toDto(product);
    }

    @Transactional
    public void deleteCategory(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product with id:" + id + "not found");
        }
        productRepository.deleteById(id);
    }
}
