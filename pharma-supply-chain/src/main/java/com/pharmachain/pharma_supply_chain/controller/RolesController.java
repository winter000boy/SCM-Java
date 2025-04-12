package com.pharmachain.pharma_supply_chain.controller;

import org.springframework.web.bind.annotation.*;
import com.pharmachain.pharma_supply_chain.security.AuthorizeRoles;
import com.pharmachain.pharma_supply_chain.model.User.UserRole;
import com.pharmachain.pharma_supply_chain.service.RolesService;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping("/assign")
    @AuthorizeRoles({UserRole.ADMIN})
    public RoleAssignmentResponse assignRole(@RequestBody RoleAssignmentRequest request) {
        return rolesService.assignRole(request);
    }

    @PostMapping("/revoke")
    @AuthorizeRoles({UserRole.ADMIN})
    public RoleRevokeResponse revokeRole(@RequestBody RoleRevokeRequest request) {
        return rolesService.revokeRole(request);
    }

    @GetMapping("/{address}")
    public UserRoleResponse getRole(@PathVariable String address) {
        return rolesService.getRole(address);
    }

    @PostMapping("/transfer-admin")
    @AuthorizeRoles({UserRole.ADMIN})
    public AdminTransferResponse transferAdmin(@RequestBody AdminTransferRequest request) {
        return rolesService.transferAdmin(request);
    }

    // Role-specific welcome endpoints
    @GetMapping("/admin")
    @AuthorizeRoles({UserRole.ADMIN})
    public String adminWelcome() {
        return "Welcome, Admin!";
    }

    @GetMapping("/supplier")
    @AuthorizeRoles({UserRole.SUPPLIER})
    public String supplierWelcome() {
        return "Welcome, Supplier!";
    }

    @GetMapping("/manufacturer")
    @AuthorizeRoles({UserRole.MANUFACTURER})
    public String manufacturerWelcome() {
        return "Welcome, Manufacturer!";
    }

    @GetMapping("/distributor")
    @AuthorizeRoles({UserRole.DISTRIBUTOR})
    public String distributorWelcome() {
        return "Welcome, Distributor!";
    }

    @GetMapping("/retailer")
    @AuthorizeRoles({UserRole.RETAILER})
    public String retailerWelcome() {
        return "Welcome, Retailer!";
    }

    @GetMapping
    public String healthCheck() {
        return "Roles API is working";
    }
}