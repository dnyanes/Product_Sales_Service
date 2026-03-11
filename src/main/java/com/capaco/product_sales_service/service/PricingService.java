package com.capaco.product_sales_service.service;

import com.capaco.product_sales_service.model.CartItem;
import com.capaco.product_sales_service.model.Client;

import java.math.BigDecimal;
import java.util.List;

public interface PricingService {

    BigDecimal calculateTotal(Client client, List<CartItem> items);
}
