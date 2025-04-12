package com.pharmachain.pharma_supply_chain.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.pharmachain.pharma_supply_chain.model.User;
import com.pharmachain.pharma_supply_chain.repository.UserRepository;
import com.pharmachain.pharma_supply_chain.exception.UserAlreadyExistsException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String email, String password, User.UserRole role) {
        if (userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException("User with email " + email + " already exists");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);

        return userRepository.save(user);
    }

    public void initializeDefaultUsers() {
        // Only create if they don't exist
        if (userRepository.count() == 0) {
            createUser("tinny00giant@gmail.com", "durgesh", User.UserRole.ADMIN);
            createUser("ds6219621966@gmail.com", "durgesh", User.UserRole.SUPPLIER);
            createUser("vishalmungal55@gmail.com", "vishal", User.UserRole.MANUFACTURER);
            createUser("amit26khairnar@gmail.com", "amit", User.UserRole.DISTRIBUTOR);
            createUser("swarajgavali619@gmail.com", "swaraj", User.UserRole.RETAILER);
        }
    }
}