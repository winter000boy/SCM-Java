package com.pharmachain.pharma_supply_chain.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.pharmachain.pharma_supply_chain.service.UserService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.initializeDefaultUsers();
    }
}