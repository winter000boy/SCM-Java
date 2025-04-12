package com.pharmachain.pharma_supply_chain.blockchain.utils;

import com.pharmachain.pharma_supply_chain.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Web3jUtils {

    // JWT Configuration
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration-ms}")
    private Long jwtExpirationMs;

    // Blockchain Configuration
    @Value("${contract.roles.address}")
    private String rolesContractAddress;
    @Value("${contract.supply-chain.address}")
    private String supplyChainContractAddress;
    @Value("${wallet.private-key}")
    private String privateKey;

    // JWT Token Generation (Replacement for auth.js)
    public String generateToken(User user) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));

            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("email", user.getEmail());
            claims.put("role", user.getRole().name());

            return Jwts.builder()
                    .setClaims(claims)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate token", e);
        }
    }

    // JWT Token Verification (Replacement for auth.js)
    public Claims verifyToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException("Invalid or expired token", e);
        }
    }

    // Blockchain Initialization (Replacement for web3.js)
    public Credentials getCredentials() {
        return Credentials.create(privateKey);
    }

    public String getRolesContractAddress() {
        return rolesContractAddress;
    }

    public String getSupplyChainContractAddress() {
        return supplyChainContractAddress;
    }

    public DefaultGasProvider getGasProvider() {
        return new DefaultGasProvider();
    }

    // Utility method to check wallet connection
    public boolean isConnected(Web3j web3j) {
        try {
            return web3j.web3ClientVersion().send().getWeb3ClientVersion() != null;
        } catch (Exception e) {
            return false;
        }
    }
}