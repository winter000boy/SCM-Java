package com.pharmachain.pharma_supply_chain.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByEmail_thenReturnUser() {
        // Given
        String email = "tinny00giant@gmail.com";

        // When
        Optional<User> foundUser = userRepository.findByEmail(email);

        // Then
        assertTrue(foundUser.isPresent(), "User should be present");
        assertEquals(email, foundUser.get().getEmail(), "Emails should match");
        System.out.println("User fetched from database: " + foundUser.get());
    }

    @Test
    public void whenFindByNonExistingEmail_thenReturnEmpty() {
        // Given
        String email = "nonexisting@example.com";

        // When
        Optional<User> foundUser = userRepository.findByEmail(email);

        // Then
        assertFalse(foundUser.isPresent(), "User should not be present");
        System.out.println("No user found with email: " + email);
    }
}