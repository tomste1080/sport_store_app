package com.example.sport_store_app.user;

import com.example.sport_store_app.address.Address;
import com.example.sport_store_app.cart.Cart;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole userRole;
    @OneToMany(mappedBy = "user")
    private List<Cart> carts = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Address> addresses = new ArrayList<>();
}
