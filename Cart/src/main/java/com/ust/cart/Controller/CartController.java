package com.ust.cart.Controller;

//CartController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ust.cart.Model.Cart;
import com.ust.cart.Repo.CartRepo;

@RestController
@RequestMapping("/carts")
public class CartController {
 private final CartRepo cartRepository;

 @Autowired
 public CartController(CartRepo cartRepository) {
     this.cartRepository = cartRepository;
 }

 // Endpoint to create a new cart
 @PostMapping
 public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
     Cart createdCart = cartRepository.save(cart);
     return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
 }

 // Endpoint to get a cart by its ID
 @GetMapping("/{id}")
 public ResponseEntity<Cart> getCartById(@PathVariable("id") Long id) {
     Cart cart = cartRepository.findById(id).orElse(null);
     if (cart != null) {
         return new ResponseEntity<>(cart, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 // Endpoint to update an existing cart
 @PutMapping("/{id}")
 public ResponseEntity<Cart> updateCart(@PathVariable("id") Long id, @RequestBody Cart updatedCart) {
     Cart cart = cartRepository.findById(id).orElse(null);
     if (cart != null) {
         cart.setUserId(updatedCart.getUserId());
         cart.setItems(updatedCart.getItems());
         Cart updated = cartRepository.save(cart);
         return new ResponseEntity<>(updated, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 // Endpoint to delete a cart by its ID
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteCart(@PathVariable("id") Long id) {
     Cart cart = cartRepository.findById(id).orElse(null);
     if (cart != null) {
         cartRepository.delete(cart);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
}

