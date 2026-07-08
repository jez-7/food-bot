package com.order.bot.domain.ports.in;

import com.order.bot.domain.models.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductUseCase {

    Product createProduct(String name, String description, BigDecimal price, String category);

    Product getProductById(UUID id);

    List<Product> getAllProducts();

    Product updateProduct(UUID id, String name, String description, BigDecimal price, String category, boolean available);

    void deleteProduct(UUID id);
}
