package com.example.sport_store_app.web;

import com.example.sport_store_app.address.AddressService;
import com.example.sport_store_app.address.dto.AddressDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<AddressDto> getUserAddress(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.getUserAddress(id));
    }

    @PostMapping("/user/{id}")
    public ResponseEntity<AddressDto> addAddressToUser(@PathVariable Long id, @RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(addressService.addAddressToUser(id, addressDto));
    }
}
