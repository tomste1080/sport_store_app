package com.example.sport_store_app.order;

import com.example.sport_store_app.Product.Product;
import com.example.sport_store_app.Product.ProductRepository;
import com.example.sport_store_app.cart.Cart;
import com.example.sport_store_app.cart.CartRepository;
import com.example.sport_store_app.cart_item.CartItem;
import com.example.sport_store_app.cart_item.CartItemRepository;
import com.example.sport_store_app.exception.ResourceNotFoundException;
import com.example.sport_store_app.order.dto.CreateOrderRequestDto;
import com.example.sport_store_app.order.dto.OrderDto;
import com.example.sport_store_app.order_item.OrderItem;
import com.example.sport_store_app.user.User;
import com.example.sport_store_app.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;

    public OrderService(OrderRepository orderRepository,
                        CartRepository cartRepository,
                        ProductRepository productRepository,
                        UserRepository userRepository,
                        CartItemRepository cartItemRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public List<OrderDto> getUserOrders(Long userId) {
        return orderRepository.findByUser_Id(userId)
                .stream()
                .map(OrderDtoMapper::toDto)
                .toList();
    }

    public OrderDto getOrderDetails(Long orderId) {
        return orderRepository.findById(orderId)
                .map(OrderDtoMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id: " + orderId + " not found"));
    }

    @Transactional
    public OrderDto updateOrderStatus(Long orderId, OrderStatus newStatus) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id: " + orderId + " not found"));
        if (newStatus != null) {
            order.setOrderStatus(newStatus);
        }
        return OrderDtoMapper.toDto(order);
    }

    @Transactional
    public OrderDto payForOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id: " + orderId + " not found"));
        order.setPaymentStatus(PaymentStatus.PAID);
        return OrderDtoMapper.toDto(order);
    }

    @Transactional
    public OrderDto createOrderFromCart(Long userId, CreateOrderRequestDto dto) {
        Cart cart = cartRepository.findByUser_Id(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart with user id: " + userId + " not found"));
        List<CartItem> cartItems = cartItemRepository.findByCart_Id(cart.getId());
        if (cartItems.isEmpty()) {
            throw new IllegalStateException("Nie można złożyć zamówienia: koszyk jest pusty");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + userId + " not found"));
        Order order = new Order();
        order.setOrderNumber("ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        order.setUser(user);
        order.setOrderStatus(OrderStatus.PENDING);
        order.setShippingStreet(dto.getShippingStreet());
        order.setShippingCity(dto.getShippingCity());
        order.setShippingPostalCode(dto.getShippingPostalCode());
        order.setCreated_at(LocalDateTime.now());
        BigDecimal totalAmount = BigDecimal.ZERO;
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();
            if (product.getQuantity() < cartItem.getQuantity()) {
                throw new IllegalStateException("Not enought product in magazine: " + product.getName());
            }
            product.setQuantity(product.getQuantity() - cartItem.getQuantity());
            productRepository.save(product);
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setName(product.getName());
            orderItem.setUnitPrice(product.getPrice());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItems.add(orderItem);
            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()));
            totalAmount = totalAmount.add(itemTotal);
        }
        order.setTotalAmount(totalAmount);
        order.setOrderItems(orderItems);
        Order savedOrder = orderRepository.save(order);
        cartItemRepository.deleteAll(cartItems);
        return OrderDtoMapper.toDto(savedOrder);
    }
}
