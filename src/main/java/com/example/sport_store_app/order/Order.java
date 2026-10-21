package com.example.sport_store_app.order;

import com.example.sport_store_app.order_item.OrderItem;
import com.example.sport_store_app.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_number")
    private String orderNumber;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus orderStatus;
    @Column(name = "shipping_street")
    private String shippingStreet;
    @Column(name = "shipping_city")
    private String shippingCity;
    @Column(name = "shipping_postal_code")
    private String shippingPostalCode;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();
}
