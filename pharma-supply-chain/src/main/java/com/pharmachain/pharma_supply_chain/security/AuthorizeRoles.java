package com.pharmachain.pharma_supply_chain.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyRole(T(com.pharmachain.pharma_supply_chain.model.User$UserRole).SUPPLIER.name(), " +
        "T(com.pharmachain.pharma_supply_chain.model.User$UserRole).MANUFACTURER.name(), " +
        "T(com.pharmachain.pharma_supply_chain.model.User$UserRole).DISTRIBUTOR.name(), " +
        "T(com.pharmachain.pharma_supply_chain.model.User$UserRole).RETAILER.name(), " +
        "T(com.pharmachain.pharma_supply_chain.model.User$UserRole).ADMIN.name())")
public @interface AuthorizeRoles {
    String[] value();
}