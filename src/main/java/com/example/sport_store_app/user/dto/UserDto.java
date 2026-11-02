package com.example.sport_store_app.user.dto;

import com.example.sport_store_app.address.dto.AddressDto;
import com.example.sport_store_app.user.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    @NotNull
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    private String email;
    @NotNull
    private String phoneNumber;
    private UserRole userRole;
    private List<AddressDto> addresses = new ArrayList<>();
}
