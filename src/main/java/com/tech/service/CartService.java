package com.tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tech.dto.CartItemDto;
import com.tech.model.CartItem;
import com.tech.repositry.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public ResponseEntity<?> addToCart(CartItemDto cartItemDto) {
        CartItem cartItem = new CartItem();
        cartItem.setProductId(cartItemDto.getProductId());
        cartItem.setQuantity(cartItemDto.getQuantity());
        cartRepository.save(cartItem);
        return ResponseEntity.ok("Product added to cart successfully");
    }

    public List<CartItem> viewCart() {
        return cartRepository.findAll();
    }

    public ResponseEntity<?> updateCartItem(CartItemDto cartItemDto) {
        Optional<CartItem> cartItemOptional = cartRepository.findById(cartItemDto.getProductId());
        if (cartItemOptional.isPresent()) {
            CartItem cartItem = cartItemOptional.get();
            cartItem.setQuantity(cartItemDto.getQuantity());
            cartRepository.save(cartItem);
            return ResponseEntity.ok("Cart item updated successfully");
        } else {
            return ResponseEntity.status(404).body("Cart item not found");
        }
    }

    public ResponseEntity<?> removeCartItem(Long id) {
        cartRepository.deleteById(id);
        return ResponseEntity.ok("Cart item removed successfully");
    }
}
