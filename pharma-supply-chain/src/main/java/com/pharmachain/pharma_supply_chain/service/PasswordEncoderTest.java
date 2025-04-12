package com.pharmachain.pharma_supply_chain.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void whenPasswordMatches_thenReturnTrue() {
        // Given
        String plainPassword = "durgesh";
        String hashedPassword = passwordEncoder.encode(plainPassword);

        // When
        boolean isMatch = passwordEncoder.matches(plainPassword, hashedPassword);

        // Then
        assertTrue(isMatch, "Passwords should match");
        System.out.println("Password match: " + isMatch);
    }

    @Test
    public void whenPasswordDoesNotMatch_thenReturnFalse() {
        // Given
        String plainPassword = "durgesh";
        String wrongPassword = "wrongpassword";
        String hashedPassword = passwordEncoder.encode(plainPassword);

        // When
        boolean isMatch = passwordEncoder.matches(wrongPassword, hashedPassword);

        // Then
        assertFalse(isMatch, "Passwords should not match");
        System.out.println("Password match: " + isMatch);
    }
}