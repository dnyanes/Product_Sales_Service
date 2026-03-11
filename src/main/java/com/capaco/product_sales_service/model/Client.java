package com.capaco.product_sales_service.model;

public sealed interface Client permits IndividualClient, ProfessionalClient {

    String clientId();
}
