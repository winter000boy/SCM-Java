package com.pharmachain.pharma_supply_chain.controller;

import org.springframework.web.bind.annotation.*;
import com.pharmachain.pharma_supply_chain.security.AuthorizeRoles;
import com.pharmachain.pharma_supply_chain.model.User.UserRole;
import com.pharmachain.pharma_supply_chain.service.SupplyChainService;

@RestController
@RequestMapping("/api/supply-chain")
public class SupplyChainController {

    private final SupplyChainService supplyChainService;

    public SupplyChainController(SupplyChainService supplyChainService) {
        this.supplyChainService = supplyChainService;
    }

    @PostMapping("/supplier/log")
    @AuthorizeRoles({UserRole.SUPPLIER})
    public BatchLogResponse logBatchDetails(@RequestBody BatchLogRequest request) {
        return supplyChainService.logBatchDetails(request);
    }

    @PutMapping("/manufacturer/update")
    @AuthorizeRoles({UserRole.MANUFACTURER})
    public ProductionUpdateResponse updateProductionDetails(@RequestBody ProductionUpdateRequest request) {
        return supplyChainService.updateProductionDetails(request);
    }

    @PutMapping("/distributor/log")
    @AuthorizeRoles({UserRole.DISTRIBUTOR})
    public TransportLogResponse logTransportDetails(@RequestBody TransportLogRequest request) {
        return supplyChainService.logTransportDetails(request);
    }

    @PutMapping("/retailer/confirm")
    @AuthorizeRoles({UserRole.RETAILER})
    public ReceiptConfirmationResponse confirmReceipt(@RequestBody ReceiptConfirmationRequest request) {
        return supplyChainService.confirmReceipt(request);
    }

    @GetMapping("/batch/{batchId}")
    public ProductVerificationResponse verifyProduct(@PathVariable String batchId) {
        return supplyChainService.verifyProduct(batchId);
    }
}