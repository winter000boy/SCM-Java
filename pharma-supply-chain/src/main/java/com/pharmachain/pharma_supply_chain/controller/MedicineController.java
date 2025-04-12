package com.pharmachain.pharma_supply_chain.controller;

import org.springframework.web.bind.annotation.*;
import com.pharmachain.pharma_supply_chain.security.AuthorizeRoles;
import com.pharmachain.pharma_supply_chain.model.User.UserRole;
import com.pharmachain.pharma_supply_chain.service.MedicineService;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/add")
    @AuthorizeRoles({UserRole.SUPPLIER})
    public MedicineResponse addMedicine(@RequestBody MedicineRequest request) {
        return medicineService.addMedicine(request);
    }

    @PostMapping("/update-manufacturing")
    @AuthorizeRoles({UserRole.MANUFACTURER})
    public MedicineResponse updateManufacturing(@RequestBody ManufacturingUpdateRequest request) {
        return medicineService.updateManufacturingDetails(request);
    }

    @GetMapping("/{medicineId}")
    public MedicineDetailsResponse getMedicineDetails(@PathVariable String medicineId) {
        return medicineService.getMedicineDetails(medicineId);
    }

    @PostMapping("/mark-as-sold")
    @AuthorizeRoles({UserRole.RETAILER})
    public MedicineResponse markAsSold(@RequestBody MarkAsSoldRequest request) {
        return medicineService.markAsSold(request);
    }
}