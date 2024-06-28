package com.tech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int quantity;
    
	public void setQuantity(int quantity2) {
		// TODO Auto-generated method stub
		
	}

	public void setProductId(Long productId2) {
		// TODO Auto-generated method stub
		
	}

    // getters and setters
}
