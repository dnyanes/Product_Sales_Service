package com.capaco.product_sales_service;

import com.capaco.product_sales_service.model.*;
import com.capaco.product_sales_service.pricing_rule.*;
import com.capaco.product_sales_service.service.PricingService;
import com.capaco.product_sales_service.service.serviceImpl.PricingServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingServiceTest {

    List<PricingRule> rules = List.of(new IndividualPricingRule(),
            new ProfessionalHighRevenueRule(),
            new ProfessionalLowRevenueRule());

    PricingEngine pricingEngine = new PricingEngine(rules);

    PricingService service = new PricingServiceImpl(pricingEngine);

    @Test
    void testIndividualPricing(){
        Client client = new IndividualClient("1", "INDIVIDUAL","Dnyan", "Shejul");

        List<CartItem> cart = List.of(new CartItem(ProductType.HIGH_END_PHONE,1),
                new CartItem(ProductType.LAPTOP, 1));

        var total = service.calculateTotal(client, cart);

        assertEquals(BigDecimal.valueOf(2700), total);
    }

    @Test
    void testProfessionalClientPricing(){
        Client client = new ProfessionalClient("1", "LTM","987374", "23648",10_000_000_0);

        List<CartItem> cart = List.of(new CartItem(ProductType.HIGH_END_PHONE,1),
                new CartItem(ProductType.LAPTOP, 1));

        var total = service.calculateTotal(client, cart);

        assertEquals(BigDecimal.valueOf(1900), total);
    }

    @Test
    void testSmallScaleProfessionalClientPricing(){
        Client client = new ProfessionalClient("1", "LTIMindtree","98723421", "23525452",10_000_00);

        List<CartItem> cart = List.of(new CartItem(ProductType.HIGH_END_PHONE,1),
                new CartItem(ProductType.LAPTOP, 1));

        var total = service.calculateTotal(client, cart);

        assertEquals(BigDecimal.valueOf(2150), total);
    }

}
