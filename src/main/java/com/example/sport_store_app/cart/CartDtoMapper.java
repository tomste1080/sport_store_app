package com.example.sport_store_app.cart;

import com.example.sport_store_app.cart.dto.CartDto;

public class CartDtoMapper {
    public static CartDto toDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setGuestToken(cart.getGuestToken());
        cartDto.setUpdated_at(cart.getUpdated_at());
        cartDto.setUserId(cart.getUser().getId());
        return cartDto;
    }

    public static Cart toEntity(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setGuestToken(cartDto.getGuestToken());
        cart.setUpdated_at(cartDto.getUpdated_at());
        return cart;
    }
}
