package com.capaco.product_sales_service.controller;

import com.capaco.product_sales_service.dto.CartResponse;
import com.capaco.product_sales_service.dto.CartRequest;
import com.capaco.product_sales_service.mapper.CartMapper;
import com.capaco.product_sales_service.model.CartItem;
import com.capaco.product_sales_service.model.Client;
import com.capaco.product_sales_service.model.IndividualClient;
import com.capaco.product_sales_service.model.ProfessionalClient;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capaco.product_sales_service.service.PricingService;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class ProductCartController {

    private final PricingService pricingService;

    public ProductCartController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @PostMapping("/calculate")
    public CartResponse calculate(@Valid @RequestBody CartRequest cartRequest){

        Client client;
        if("INDIVIDUAL".equalsIgnoreCase(cartRequest.clientType())){
            client = new IndividualClient(cartRequest.clientId(), cartRequest.clientType(), cartRequest.firstName(), cartRequest.lastName());

        } else{
            client = new ProfessionalClient(cartRequest.clientId(), cartRequest.companyName(), cartRequest.vatNumber(), cartRequest.registrationNumber(), cartRequest.annualRevenue());
        }

        List<CartItem> items = CartMapper.toCartItems(cartRequest.items());

        var total = pricingService.calculateTotal(client, items);

        return new CartResponse(total);
    }

}
