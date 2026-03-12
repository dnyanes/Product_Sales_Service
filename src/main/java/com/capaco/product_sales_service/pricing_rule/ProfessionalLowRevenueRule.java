package com.capaco.product_sales_service.pricing_rule;

import com.capaco.product_sales_service.model.Client;
import com.capaco.product_sales_service.model.ProductType;
import com.capaco.product_sales_service.model.ProfessionalClient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProfessionalLowRevenueRule implements PricingRule {
    @Override
    public boolean supports(Client client) {
        return client instanceof ProfessionalClient pro && pro.annualRevenue() <= 10_000_000;
    }

    @Override
    public BigDecimal price(ProductType productType) {
        return switch (productType){
            case HIGH_END_PHONE -> BigDecimal.valueOf(1150);
            case MID_RANGE_PHONE -> BigDecimal.valueOf(600);
            case LAPTOP -> BigDecimal.valueOf(1000);
        };
    }
}
