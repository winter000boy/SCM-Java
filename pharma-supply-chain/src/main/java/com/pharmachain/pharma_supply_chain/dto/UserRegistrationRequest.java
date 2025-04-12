package com.pharmachain.pharma_supply_chain.dto;

import com.pharmachain.pharma_supply_chain.model.User.UserRole;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserRegistrationRequest {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private UserRole role;

    private String companyName;
    private String contactNumber;
}