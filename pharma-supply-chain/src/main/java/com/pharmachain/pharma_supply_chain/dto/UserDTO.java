package com.pharmachain.pharma_supply_chain.dto;

import com.pharmachain.pharma_supply_chain.model.User.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private UserRole role;
    private LocalDateTime createdAt;
    private String companyName;
    private String contactNumber;
}