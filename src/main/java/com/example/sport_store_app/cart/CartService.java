package com.example.sport_store_app.cart;

import com.example.sport_store_app.Product.Product;
import com.example.sport_store_app.Product.ProductRepository;
import com.example.sport_store_app.cart.dto.AddToCartDto;
import com.example.sport_store_app.cart.dto.CartDto;
import com.example.sport_store_app.cart_item.CartItem;
import com.example.sport_store_app.cart_item.CartItemRepository;
import com.example.sport_store_app.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public CartDto getCartById(Long id) {
        return cartRepository.findById(id)
                .map(CartDtoMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + id + " not found"));
    }

    @Transactional
    public CartDto addItemToCart(Long userId, AddToCartDto dto) {
        Cart cart = findByUserId(userId);
        Optional<CartItem> existingItem = cartItemRepository.findByCart_IdAndProduct_Id(cart.getId(), dto.getProductId());
        if (existingItem.isPresent()) {
            CartItem cartItem = existingItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + dto.getQuantity());
            cartItemRepository.save(cartItem);
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            Product product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product with ID: " + dto.getProductId() + " not found"));
            cartItem.setProduct(product);
            cartItem.setQuantity(dto.getQuantity());
            cartItemRepository.save(cartItem);
        }
        cart.setUpdated_at(LocalDateTime.now());
        cartRepository.save(cart);
        return CartDtoMapper.toDto(cart);
    }

    private Cart findByUserId(Long userId) {
        return cartRepository.findByUser_Id(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart with this user ID " + userId + " not found"));
    }

    @Transactional
    public void clearCart(Long userId) {
        Cart cart = findByUserId(userId);
        cartItemRepository.deleteByCart_Id(cart.getId());
        cart.setUpdated_at(LocalDateTime.now());
        cartRepository.save(cart);
    }

    @Transactional
    public void removeItemFromCart(Long userId, Long cartItemId) {
        Cart cart = findByUserId(userId);
        CartItem cartItem = cartItemRepository.findByIdAndCart_Id(cartItemId, cart.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Item with ID: " + cartItemId + " not found"));
        cartItemRepository.delete(cartItem);
        cart.setUpdated_at(LocalDateTime.now());
        cartRepository.save(cart);
    }
}
