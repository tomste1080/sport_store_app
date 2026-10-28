package com.example.sport_store_app.cart;

import com.example.sport_store_app.cart.dto.CartDto;
import com.example.sport_store_app.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartDto getCartById(Long id) {
        return cartRepository.findById(id)
                .map(CartDtoMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + id + " not found"));
    }
}
