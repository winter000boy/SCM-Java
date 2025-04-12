package com.pharmachain.pharma_supply_chain.controller;

import org.springframework.web.bind.annotation.*;
import com.pharmachain.pharma_supply_chain.dto.*;
import com.pharmachain.pharma_supply_chain.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        return authService.authenticateUser(request);
    }

    @GetMapping("/validate-token")
    public TokenValidationResponse validateToken(@RequestHeader("Authorization") String token) {
        return authService.validateToken(token.replace("Bearer ", ""));
    }
}