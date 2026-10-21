package com.example.sport_store_app.order_item.dto;

import com.example.sport_store_app.Product.Product;
import com.example.sport_store_app.Product.dto.ProductDto;
import com.example.sport_store_app.order.Order;
import com.example.sport_store_app.order.dto.OrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDto {
    private Long id;
    private String name;
    private BigDecimal unitPrice;
    private Integer quantity;
    private OrderDto orderDto;
    private ProductDto productDto;
}
