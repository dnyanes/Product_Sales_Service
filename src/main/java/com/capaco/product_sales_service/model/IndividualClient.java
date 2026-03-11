package com.capaco.product_sales_service.model;

public record IndividualClient (
        String clientId,
        String clientType,
        String firstName,
        String lastName
) implements Client {}
