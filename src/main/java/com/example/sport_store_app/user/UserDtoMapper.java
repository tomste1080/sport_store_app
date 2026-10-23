package com.example.sport_store_app.user;

import com.example.sport_store_app.user.dto.UserDto;

public class UserDtoMapper {
    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setUserRole(user.getUserRole());
        return userDto;
    }

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUserRole(userDto.getUserRole());
        return user;
    }
}
