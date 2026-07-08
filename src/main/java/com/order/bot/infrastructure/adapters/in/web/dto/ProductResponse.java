package com.order.bot.infrastructure.adapters.in.web.dto;

import com.order.bot.domain.models.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductResponse {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private boolean available;

    public ProductResponse() {}

    public static ProductResponse fromDomain(Product product) {
        ProductResponse response = new ProductResponse();
        response.id = product.getId();
        response.name = product.getName();
        response.description = product.getDescription();
        response.price = product.getPrice();
        response.category = product.getCategory();
        response.available = product.isAvailable();
        return response;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getPrice() { return price; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return available; }
}
