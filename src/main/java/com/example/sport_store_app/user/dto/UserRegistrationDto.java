package com.example.sport_store_app.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String secPassword;
    private String phoneNumber;
}
