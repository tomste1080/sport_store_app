package com.example.sport_store_app.cart.dto;

import com.example.sport_store_app.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CartDto {
    private Long id;
    private String guestToken;
    private LocalDateTime updated_at;
    private Long userId;
}
