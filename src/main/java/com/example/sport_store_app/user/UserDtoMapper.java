package com.example.sport_store_app.user;

import com.example.sport_store_app.user.dto.UserDto;

public class UserDtoMapper {
    public static UserDto map(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setUserRole(user.getUserRole());
        return userDto;
    }
}
