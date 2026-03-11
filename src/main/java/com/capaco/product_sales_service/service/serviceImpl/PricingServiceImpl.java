package com.capaco.product_sales_service.service.serviceImpl;

import com.capaco.product_sales_service.model.*;
import org.springframework.stereotype.Service;
import com.capaco.product_sales_service.service.PricingService;

import java.math.BigDecimal;
import java.util.List;
@Service
public class PricingServiceImpl implements PricingService {
    @Override
    public BigDecimal calculateTotal(Client client, List<CartItem> items) {

        return items.stream()
                .map(item -> getPrice(client, item.productType())
                        .multiply(BigDecimal.valueOf(item.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getPrice(Client client, ProductType productType) {

        return switch (client) {
            case IndividualClient individualClient -> switch (productType) {
                case HIGH_END_PHONE -> BigDecimal.valueOf(1500);
                case MID_RANGE_PHONE -> BigDecimal.valueOf(800);
                case LAPTOP -> BigDecimal.valueOf(1200);
            };
            case ProfessionalClient professionalClient
                    when professionalClient.annualRevenue() > 10000000 -> switch (productType) {
                case HIGH_END_PHONE -> BigDecimal.valueOf(1000);
                case MID_RANGE_PHONE -> BigDecimal.valueOf(550);
                case LAPTOP -> BigDecimal.valueOf(900);
            };
            case ProfessionalClient professionalClient -> switch (productType) {
                case HIGH_END_PHONE -> BigDecimal.valueOf(1150);
                case MID_RANGE_PHONE -> BigDecimal.valueOf(600);
                case LAPTOP -> BigDecimal.valueOf(1000);
            };
        };
    }
}
