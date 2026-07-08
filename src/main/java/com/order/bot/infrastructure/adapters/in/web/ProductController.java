package com.order.bot.infrastructure.adapters.in.web;

import com.order.bot.domain.models.Product;
import com.order.bot.domain.ports.in.ProductUseCase;
import com.order.bot.infrastructure.adapters.in.web.dto.CreateProductRequest;
import com.order.bot.infrastructure.adapters.in.web.dto.ProductResponse;
import com.order.bot.infrastructure.adapters.in.web.dto.UpdateProductRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
        Product product = productUseCase.createProduct(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getCategory()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductResponse.fromDomain(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productUseCase.getAllProducts()
                .stream()
                .map(ProductResponse::fromDomain)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable UUID id) {
        Product product = productUseCase.getProductById(id);
        return ResponseEntity.ok(ProductResponse.fromDomain(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateProductRequest request) {
        Product product = productUseCase.updateProduct(
                id,
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getCategory(),
                request.isAvailable()
        );
        return ResponseEntity.ok(ProductResponse.fromDomain(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productUseCase.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
