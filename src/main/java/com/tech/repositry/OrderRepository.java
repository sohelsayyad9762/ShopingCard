package com.tech.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
