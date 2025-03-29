package com.example.OrderService.feign;

import org.springframework.stereotype.Component;

import com.example.OrderService.dto.ProductDTO;

@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public ProductDTO getProductById(Long id) {
        return new ProductDTO(id, "Unknown Product", 0.0); // Default response
    }
}

// useless class, fallback doesnt work in feign