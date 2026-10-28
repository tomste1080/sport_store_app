package com.example.sport_store_app.user;

import com.example.sport_store_app.address.Address;
import com.example.sport_store_app.address.AddressDtoMapper;
import com.example.sport_store_app.address.dto.AddressDto;
import com.example.sport_store_app.user.dto.UserDto;

import java.util.List;

public class UserDtoMapper {
    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setUserRole(user.getUserRole());
        List<AddressDto> addressDtos = user.getAddresses().stream()
                .map(AddressDtoMapper::toDto)
                .toList();
        userDto.setAddresses(addressDtos);
        return userDto;
    }

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUserRole(userDto.getUserRole());
        List<Address> addresses = userDto.getAddresses().stream()
                .map(dto -> {
                    Address address = AddressDtoMapper.toEntity(dto);
                    address.setUser(user);
                    return address;
                })
                .toList();
        user.setAddresses(addresses);
        return user;
    }
}
