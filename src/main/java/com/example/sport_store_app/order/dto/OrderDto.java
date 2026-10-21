package com.example.sport_store_app.order.dto;

import com.example.sport_store_app.order.OrderStatus;
import com.example.sport_store_app.order.PaymentStatus;
import com.example.sport_store_app.user.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String orderNumber;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
    private String shippingStreet;
    private String shippingCity;
    private String shippingPostalCode;
    private PaymentStatus paymentStatus;
    private LocalDateTime created_at;
    private UserDto userDto;
}
