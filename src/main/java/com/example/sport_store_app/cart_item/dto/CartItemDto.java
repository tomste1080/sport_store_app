package com.example.sport_store_app.cart_item.dto;

import com.example.sport_store_app.Product.Product;
import com.example.sport_store_app.cart.Cart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartItemDto {
    private Long id;
    private Integer quantity;
    private Cart cart;
    private Product product;
}
