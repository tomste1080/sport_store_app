package com.example.sport_store_app.user;

import com.example.sport_store_app.exception.EmailExistException;
import com.example.sport_store_app.exception.NotMatchPasswordException;
import com.example.sport_store_app.exception.ResourceNotFoundException;
import com.example.sport_store_app.user.dto.UserDto;
import com.example.sport_store_app.user.dto.UserRegistrationDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserProfile(Long userId) {
        return userRepository.findById(userId)
                .map(UserDtoMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("User with id:" + userId + "not found"));
    }

    @Transactional
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id:" + id + "not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUserRole(UserRole.USER);
        return UserDtoMapper.toDto(user);
    }

    @Transactional
    public UserDto registerUser(UserRegistrationDto userRegistrationDto) {
        if (userRepository.existsByEmail(userRegistrationDto.getEmail())) {
            throw new EmailExistException("This email already exists: " + userRegistrationDto.getEmail());
        }
        if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getSecPassword())) {
            throw new NotMatchPasswordException("The passwords are not the same");
        }
        User user = new User();
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(userRegistrationDto.getPassword());
        user.setPhoneNumber(userRegistrationDto.getPhoneNumber());
        user.setUserRole(UserRole.USER);
        User savedUser = userRepository.save(user);
        return UserDtoMapper.toDto(savedUser);
    }
}
