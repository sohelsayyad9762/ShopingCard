package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tech.model.CartItem;
import com.tech.model.Order;
import com.tech.model.Product;
import com.tech.service.CartService;
import com.tech.service.OrderService;
import com.tech.service.ProductService;

@Controller
public class ViewController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        List<CartItem> cartItems = cartService.viewCart();
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        List<Order> orders = orderService.getOrderHistory();
        model.addAttribute("orders", orders);
        return "orders";
    }
}


        		