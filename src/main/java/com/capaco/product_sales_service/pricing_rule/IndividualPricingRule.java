package com.capaco.product_sales_service.pricing_rule;

import com.capaco.product_sales_service.model.Client;
import com.capaco.product_sales_service.model.IndividualClient;
import com.capaco.product_sales_service.model.ProductType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IndividualPricingRule implements PricingRule {
    @Override
    public boolean supports(Client client) {
        return client instanceof IndividualClient;
    }

    @Override
    public BigDecimal price(ProductType productType) {
        return switch (productType){
            case HIGH_END_PHONE -> BigDecimal.valueOf(1500);
            case MID_RANGE_PHONE -> BigDecimal.valueOf(800);
            case LAPTOP -> BigDecimal.valueOf(1200);
        };
    }
}
