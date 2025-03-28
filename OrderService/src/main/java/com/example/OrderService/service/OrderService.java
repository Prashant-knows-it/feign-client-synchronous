package com.example.OrderService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.OrderService.dto.ProductDTO;
import com.example.OrderService.feign.ProductClient;
import com.example.OrderService.model.Order;
import com.example.OrderService.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public OrderService(OrderRepository orderRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order placeOrder(Order order) {
        // Fetch product details via Feign
        ProductDTO product = productClient.getProductById(order.getProductId());

        if (product != null) {
            return orderRepository.save(order);
        }
        return null; // Handle properly in real-world cases
    }
}
