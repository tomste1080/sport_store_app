package com.example.sport_store_app.cart;

import com.example.sport_store_app.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "guest_token")
    private String guestToken;
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}
