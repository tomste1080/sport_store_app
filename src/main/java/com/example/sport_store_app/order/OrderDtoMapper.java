package com.example.sport_store_app.order;

import com.example.sport_store_app.order.dto.OrderDto;
import com.example.sport_store_app.user.UserDtoMapper;

public class OrderDtoMapper {
    public static OrderDto map(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setOrderNumber(order.getOrderNumber());
        orderDto.setTotalAmount(order.getTotalAmount());
        orderDto.setOrderStatus(order.getOrderStatus());
        orderDto.setShippingStreet(order.getShippingStreet());
        orderDto.setShippingCity(order.getShippingCity());
        orderDto.setShippingPostalCode(order.getShippingPostalCode());
        orderDto.setPaymentStatus(order.getPaymentStatus());
        orderDto.setCreated_at(order.getCreated_at());
        orderDto.setUserDto(UserDtoMapper.toDto(order.getUser()));
        return orderDto;
    }
}
