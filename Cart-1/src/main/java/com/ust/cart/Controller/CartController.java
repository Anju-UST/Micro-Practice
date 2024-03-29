package com.ust.cart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.cart.Model.Cart;
import com.ust.cart.Repo.CartRepository;


@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:4200/")
//@CrossOrigin("*")
public class CartController {
    private final CartRepository cartItemRepository;

    @Autowired
    public CartController(CartRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @PostMapping("/items")
    public ResponseEntity<String> addToCart(@RequestBody Cart cartItem) {
        cartItemRepository.save(cartItem);
        return ResponseEntity.ok("Item added to cart successfully");
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeFromCart(@PathVariable long id) {
        cartItemRepository.deleteById(id);
        return ResponseEntity.ok("Item removed from cart successfully");
    }

    @GetMapping("/items")
    public ResponseEntity<List<Cart>> getCartItems() {
        List<Cart> cartItems = cartItemRepository.findAll();
        return ResponseEntity.ok(cartItems);
    }
}
