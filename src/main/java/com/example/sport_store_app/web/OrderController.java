package com.example.sport_store_app.web;

import com.example.sport_store_app.order.OrderService;
import com.example.sport_store_app.order.OrderStatus;
import com.example.sport_store_app.order.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> getUserOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getUserOrders(userId));
    }

    @GetMapping("/orderId")
    public ResponseEntity<OrderDto> getOrderDetails(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrdersDetails(orderId));
    }

    @PatchMapping("/{orderId}/status")
    public ResponseEntity<OrderDto> updateOrderStatus(@PathVariable Long orderId, @RequestBody OrderStatus newStatus) {
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, newStatus));
    }

    @PostMapping("/{orderId}/pay")
    public ResponseEntity<OrderDto> payForOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.payForOrder(orderId));
    }
}
