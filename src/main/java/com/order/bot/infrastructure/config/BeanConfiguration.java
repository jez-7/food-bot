package com.order.bot.infrastructure.config;

import com.order.bot.application.services.ProductService;
import com.order.bot.domain.ports.in.ProductUseCase;
import com.order.bot.domain.ports.out.ProductRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductUseCase productUseCase(ProductRepositoryPort productRepositoryPort) {
        return new ProductService(productRepositoryPort);
    }
}
