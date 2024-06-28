package com.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tech.model.CartItem;
import com.tech.model.Order;
import com.tech.repositry.CartRepository;
import com.tech.repositry.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    public ResponseEntity<?> placeOrder() {
        List<CartItem> cartItems = cartRepository.findAll();
        Order order = new Order();
        order.setItems(cartItems);
        orderRepository.save(order);
        cartRepository.deleteAll();
        return ResponseEntity.ok("Order placed successfully");
    }

    public List<Order> getOrderHistory() {
        return orderRepository.findAll();
    }
}
