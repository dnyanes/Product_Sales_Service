package com.capaco.product_sales_service;

import com.capaco.product_sales_service.model.CartItem;
import com.capaco.product_sales_service.model.Client;
import com.capaco.product_sales_service.model.IndividualClient;
import com.capaco.product_sales_service.model.ProductType;
import com.capaco.product_sales_service.service.PricingService;
import com.capaco.product_sales_service.service.serviceImpl.PricingServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingServiceTest {

    PricingService service = new PricingServiceImpl();

    @Test
    void testIndividualPricing(){
        Client client = new IndividualClient("1", "INDIVIDUAL","Dnyan", "Shejul");

        List<CartItem> cart = List.of(new CartItem(ProductType.HIGH_END_PHONE,1),
                new CartItem(ProductType.LAPTOP, 1));

        var total = service.calculateTotal(client, cart);

        assertEquals(BigDecimal.valueOf(2700), total);
    }

}
