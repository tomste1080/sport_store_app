package com.example.sport_store_app.address;

import com.example.sport_store_app.address.dto.AddressDto;
import com.example.sport_store_app.exception.ResourceNotFoundException;
import com.example.sport_store_app.user.User;
import com.example.sport_store_app.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressService(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public AddressDto getUserAddress(Long id) {
        return addressRepository.findById(id)
                .map(AddressDtoMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Address with id: " + id + " not found"));
    }

    @Transactional
    public AddressDto addAddressToUser(Long id, AddressDto addressDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));
        Address address = AddressDtoMapper.toEntity(addressDto);
        address.setUser(user);
        user.getAddresses().add(address);
        Address addressToSaved = addressRepository.save(address);
        return AddressDtoMapper.toDto(addressToSaved);
    }
}
