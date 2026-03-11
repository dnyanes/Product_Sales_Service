package com.capaco.product_sales_service.model;

public record CartItem(
        ProductType productType,
        int quantity
) {}
