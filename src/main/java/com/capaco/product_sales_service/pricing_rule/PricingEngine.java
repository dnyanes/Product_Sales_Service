package com.capaco.product_sales_service.pricing_rule;

import com.capaco.product_sales_service.model.Client;
import com.capaco.product_sales_service.model.ProductType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PricingEngine {

    private final List<PricingRule> rules;

    public PricingEngine(List<PricingRule> rules) {
        this.rules = rules;
    }

    public BigDecimal getPrice(Client client, ProductType productType){

        return rules.stream()
                .filter(rule -> rule.supports(client))
                .findFirst()
                .orElseThrow()
                .price(productType);
    }
}
