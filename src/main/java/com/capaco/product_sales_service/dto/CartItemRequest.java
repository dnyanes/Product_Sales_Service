package com.capaco.product_sales_service.dto;

import com.capaco.product_sales_service.model.ProductType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CartItemRequest(

        @NotNull
        ProductType productType,

        @Min(1)
        int quantity
) {}
