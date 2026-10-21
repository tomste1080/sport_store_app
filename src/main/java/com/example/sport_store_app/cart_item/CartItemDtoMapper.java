package com.example.sport_store_app.cart_item;

import com.example.sport_store_app.cart_item.dto.CartItemDto;

public class CartItemDtoMapper {
    public static CartItemDto map(CartItem cartItem) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setId(cartItem.getId());
        cartItemDto.setQuantity(cartItem.getQuantity());
        cartItemDto.setCart(cartItem.getCart());
        cartItemDto.setProduct(cartItem.getProduct());
        return cartItemDto;
    }
}
