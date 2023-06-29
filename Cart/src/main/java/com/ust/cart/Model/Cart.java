package com.ust.cart.Model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private String cartId;
 private String userId;
 private List<CartItem> items;

 public Cart(String cartId, String userId) {
     this.cartId = cartId;
     this.userId = userId;
     this.items = new ArrayList<>();
 }

 public String getCartId() {
     return cartId;
 }

 public void setCartId(String cartId) {
     this.cartId = cartId;
 }

 public String getUserId() {
     return userId;
 }

 public void setUserId(String userId) {
     this.userId = userId;
 }

 public List<CartItem> getItems() {
     return items;
 }

 public void setItems(List<CartItem> items) {
     this.items = items;
 }
}
