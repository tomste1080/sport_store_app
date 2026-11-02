package com.example.sport_store_app.cart_item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByCart_IdAndProduct_Id(Long cartId, Long productId);
    
    void deleteByCart_Id(Long cartId);

    Optional<CartItem> findByIdAndCart_Id(Long id, Long cartId);
    
    List<CartItem> findByCart_Id(Long cartId);
}
