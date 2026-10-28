package com.example.sport_store_app.user.dto;

import com.example.sport_store_app.address.dto.AddressDto;
import com.example.sport_store_app.user.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private UserRole userRole;
    private List<AddressDto> addresses = new ArrayList<>();
}
