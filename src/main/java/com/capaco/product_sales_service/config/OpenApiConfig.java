package com.capaco.product_sales_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product Sale Shopping Cart API")
                        .description("Product Cart calculation service")
                        .version("1.0"));
    }
}
