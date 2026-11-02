package com.example.sport_store_app.cart.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddToCartDto {
    @NotNull
    private Long productId;
    @Min(0)
    private Integer quantity;
}
