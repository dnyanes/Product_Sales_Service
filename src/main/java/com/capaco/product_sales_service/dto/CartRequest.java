package com.capaco.product_sales_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CartRequest(
        String clientType,
        String clientId,
        String firstName,
        String lastName,
        String companyName,
        String vatNumber,
        String registrationNumber,
        Double annualRevenue,

        @Valid
        @NotEmpty
        List<CartItemRequest> items
) {}
