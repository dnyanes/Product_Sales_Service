FROM eclipse-temurin:21
WORKDIR /app

COPY target/product_sales_service.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]