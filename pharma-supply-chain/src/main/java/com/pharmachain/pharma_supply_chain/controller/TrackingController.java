package com.pharmachain.pharma_supply_chain.controller;

import org.springframework.web.bind.annotation.*;
import com.pharmachain.pharma_supply_chain.security.AuthorizeRoles;
import com.pharmachain.pharma_supply_chain.model.User.UserRole;
import com.pharmachain.pharma_supply_chain.service.TrackingService;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    private final TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping("/history/{productId}")
    public ProductHistoryResponse getProductHistory(@PathVariable String productId) {
        return trackingService.getProductHistory(productId);
    }

    @GetMapping("/status/{productId}")
    public ProductStatusResponse getProductStatus(@PathVariable String productId) {
        return trackingService.getProductStatus(productId);
    }

    @PostMapping("/update-storage")
    @AuthorizeRoles({UserRole.DISTRIBUTOR})
    public StorageUpdateResponse updateStorageConditions(@RequestBody StorageUpdateRequest request) {
        return trackingService.updateStorageConditions(request);
    }
}