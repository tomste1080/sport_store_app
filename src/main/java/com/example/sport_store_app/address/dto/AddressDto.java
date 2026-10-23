package com.example.sport_store_app.address.dto;

import com.example.sport_store_app.user.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {
    private Long id;
    private String street;
    private String houseNumber;
    private String city;
    private String postalCode;
    private String country;
    private UserDto userDto;
}
