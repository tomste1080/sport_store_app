package com.example.sport_store_app.address;

import com.example.sport_store_app.address.dto.AddressDto;

public class AddressDtoMapper {
    public static AddressDto map(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setStreet(address.getStreet());
        addressDto.setHouseNumber(address.getHouseNumber());
        addressDto.setCity(address.getCity());
        addressDto.setPostalCode(address.getPostalCode());
        addressDto.setCountry(address.getCountry());
        return addressDto;
    }
}
