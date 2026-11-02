package com.example.sport_store_app.cart;

import com.example.sport_store_app.cart.dto.CartDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUser_Id(Long userId);
}
