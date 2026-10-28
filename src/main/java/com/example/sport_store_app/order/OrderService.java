package com.example.sport_store_app.order;

import com.example.sport_store_app.cart.CartRepository;
import com.example.sport_store_app.exception.ResourceNotFoundException;
import com.example.sport_store_app.order.dto.CreateOrderRequestDto;
import com.example.sport_store_app.order.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderService(OrderRepository orderRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    public List<OrderDto> getUserOrders(Long userId) {
        return orderRepository.findByUser_Id(userId)
                .stream()
                .map(OrderDtoMapper::toDto)
                .toList();
    }

    public OrderDto getOrdersDetails(Long orderId) {
        return orderRepository.findById(orderId)
                .map(OrderDtoMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id: " + orderId + " not found"));
    }

    public OrderDto updateOrderStatus(Long orderId, OrderStatus newStatus) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id: " + orderId + " not found"));
        if (newStatus != null) {
            order.setOrderStatus(newStatus);
        }
        return OrderDtoMapper.toDto(order);
    }

    public OrderDto payForOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id: " + orderId + " not found"));
        order.setPaymentStatus(PaymentStatus.PAID);
        return OrderDtoMapper.toDto(order);
    }
}
