package com.example.sport_store_app.address;

import com.example.sport_store_app.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    @Column(name = "house_number")
    private String houseNumber;
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    private String country;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}
