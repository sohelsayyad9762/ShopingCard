package com.tech.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.model.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Long> {
}
