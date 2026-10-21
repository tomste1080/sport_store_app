package com.example.sport_store_app.order_item;

import com.example.sport_store_app.Product.Product;
import com.example.sport_store_app.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "products_id")
    private Product product;
}
