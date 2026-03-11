package com.capaco.product_sales_service.model;

public record ProfessionalClient(
        String clientId,
        String companyName,
        String vatNumber,
        String registrationNumber,
        double annualRevenue
) implements Client {}
