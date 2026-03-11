package com.capaco.product_sales_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductCartControllerTest.class)
public class ProductCartControllerTest {

    @Autowired
    MockMvc mockMvc;

    void testCartApi() throws Exception
    {
        String request = """
                {
                    "clientType" : "INDIVIDUAL",
                    "clientId" : "C1",
                    "firstName" : "Dnyan",
                    "lastName" : "Shejul",
                    "items" : [
                    {"producttype" : "HIGH_END_PHONE", "quantity" : 1}]
                }
                """;
        mockMvc.perform(post("/cart/calculate")
                .contentType("application/json")
                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(1500));
    }
}
