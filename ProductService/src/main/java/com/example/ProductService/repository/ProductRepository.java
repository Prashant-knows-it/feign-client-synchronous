package com.example.ProductService.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductService.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
