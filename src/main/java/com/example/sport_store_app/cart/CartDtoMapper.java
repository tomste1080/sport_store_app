package com.example.sport_store_app.cart;

import com.example.sport_store_app.cart.dto.CartDto;

public class CartDtoMapper {
    public static CartDto map(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setGuestToken(cart.getGuestToken());
        cartDto.setUpdated_at(cart.getUpdated_at());
        cartDto.setUser(cart.getUser());
        return cartDto;
    }
}
