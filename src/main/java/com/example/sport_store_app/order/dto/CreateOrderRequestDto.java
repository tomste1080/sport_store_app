package com.example.sport_store_app.order.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateOrderRequestDto {
    @NotNull
    private String shippingStreet;
    @NotNull
    private String shippingCity;
    @NotNull
    private String shippingPostalCode;
}
