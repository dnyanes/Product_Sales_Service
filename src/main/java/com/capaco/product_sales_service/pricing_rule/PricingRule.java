package com.capaco.product_sales_service.pricing_rule;

import com.capaco.product_sales_service.model.Client;
import com.capaco.product_sales_service.model.ProductType;

import java.math.BigDecimal;

public interface PricingRule {

    boolean supports(Client client);

    BigDecimal price(ProductType productType);
}
