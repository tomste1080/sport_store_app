package com.example.sport_store_app.cart.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddToCartDto {
    private Long productId;
    private Integer quantity;
}
