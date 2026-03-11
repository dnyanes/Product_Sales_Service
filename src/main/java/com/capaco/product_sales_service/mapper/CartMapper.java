package com.capaco.product_sales_service.mapper;

import com.capaco.product_sales_service.dto.CartItemRequest;
import com.capaco.product_sales_service.model.CartItem;

import java.util.List;

public class CartMapper {

    public static List<CartItem> toCartItems(List<CartItemRequest> requests) {

        return requests.stream()
                .map(i -> new CartItem(i.productType(), i.quantity())).toList();
    }
}
