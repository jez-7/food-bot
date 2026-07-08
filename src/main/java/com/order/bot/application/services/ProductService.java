package com.order.bot.application.services;

import com.order.bot.domain.models.Product;
import com.order.bot.domain.ports.in.ProductUseCase;
import com.order.bot.domain.ports.out.ProductRepositoryPort;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product createProduct(String name, String description, BigDecimal price, String category) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }
        Product product = new Product(null, name, description, price, category, true);
        return productRepositoryPort.save(product);
    }

    @Override
    public Product getProductById(UUID id) {
        return productRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepositoryPort.findAll();
    }

    @Override
    public Product updateProduct(UUID id, String name, String description, BigDecimal price, String category, boolean available) {
        if (!productRepositoryPort.existsById(id)) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero");
        }
        Product updated = new Product(id, name, description, price, category, available);
        return productRepositoryPort.save(updated);
    }

    @Override
    public void deleteProduct(UUID id) {
        if (!productRepositoryPort.existsById(id)) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
        productRepositoryPort.deleteById(id);
    }
}
