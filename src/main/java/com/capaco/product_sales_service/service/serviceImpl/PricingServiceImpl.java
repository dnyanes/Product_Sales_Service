package com.capaco.product_sales_service.service.serviceImpl;

import com.capaco.product_sales_service.model.*;
import com.capaco.product_sales_service.pricing_rule.PricingEngine;
import org.springframework.stereotype.Service;
import com.capaco.product_sales_service.service.PricingService;

import java.math.BigDecimal;
import java.util.List;
@Service
public class PricingServiceImpl implements PricingService {

    private final PricingEngine pricingEngine;

    public PricingServiceImpl(PricingEngine pricingEngine) {
        this.pricingEngine = pricingEngine;
    }

    @Override
    public BigDecimal calculateTotal(Client client, List<CartItem> items) {

        return items.stream()
                .map(item -> pricingEngine.getPrice(client, item.productType())
                        .multiply(BigDecimal.valueOf(item.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
