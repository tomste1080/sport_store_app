package com.example.sport_store_app.web;

import com.example.sport_store_app.cart.CartService;
import com.example.sport_store_app.cart.dto.AddToCartDto;
import com.example.sport_store_app.cart.dto.CartDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getCart(@PathVariable Long id) {
        return ResponseEntity.ok(cartService.getCartById(id));
    }

    @PostMapping("/{userId}/items")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable Long userId, @RequestBody AddToCartDto dto) {
        return ResponseEntity.ok(cartService.addItemToCart(userId, dto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}/items/{cartItemId}")
    public ResponseEntity<Void> removeItemFromCart(@PathVariable Long userId, @PathVariable Long cartItemId) {
        cartService.removeItemFromCart(userId, cartItemId);
        return ResponseEntity.noContent().build();
    }
}
