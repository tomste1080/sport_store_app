package com.example.sport_store_app.address.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {
    @NotNull
    private Long id;
    @NotNull
    private String street;
    @NotNull
    private String houseNumber;
    @NotNull
    private String city;
    @NotNull
    private String postalCode;
    @NotNull
    private String country;
}
