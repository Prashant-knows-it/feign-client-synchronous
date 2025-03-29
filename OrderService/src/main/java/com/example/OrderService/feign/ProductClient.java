package com.example.OrderService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.OrderService.dto.ProductDTO;

@FeignClient(
    name = "product-service",
    url = "http://localhost:8081",
    fallback = ProductClientFallback.class, // remove this line, its of no use, use resilience4j instead
    configuration = FeignRetryConfig.class
)
public interface ProductClient {
    @GetMapping("/api/products/{id}")
    ProductDTO getProductById(@PathVariable Long id);
}
