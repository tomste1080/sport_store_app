package com.example.sport_store_app.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateOrderRequestDto {
    private String shippingStreet;
    private String shippingCity;
    private String shippingPostalCode;
}
