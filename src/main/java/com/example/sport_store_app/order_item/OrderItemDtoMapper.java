package com.example.sport_store_app.order_item;

import com.example.sport_store_app.order.OrderDtoMapper;
import com.example.sport_store_app.order_item.dto.OrderItemDto;
import com.example.sport_store_app.user.UserDtoMapper;

public class OrderItemDtoMapper {
    public static OrderItemDto map(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setName(orderItem.getName());
        orderItemDto.setUnitPrice(orderItem.getUnitPrice());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setOrderDto(OrderDtoMapper.map(orderItem.getOrder()));
        return orderItemDto;
    }
}
