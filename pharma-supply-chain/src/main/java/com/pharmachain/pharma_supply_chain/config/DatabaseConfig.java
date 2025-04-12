package com.pharmachain.pharma_supply_chain.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.driver-class-name:org.postgresql.Driver}") // Default to PostgreSQL driver
    private String dbDriver;

    @Bean
    public DataSource dataSource() {
        try {
            return DataSourceBuilder.create()
                    .url(dbUrl)
                    .username(dbUser)
                    .password(dbPassword)
                    .driverClassName(dbDriver)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Failed to configure the DataSource", e);
        }
    }
}