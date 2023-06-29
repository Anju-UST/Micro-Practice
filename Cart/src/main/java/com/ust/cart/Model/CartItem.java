package com.ust.cart.Model;

//CartItem.java

public class CartItem {
 private String itemId;
 private String itemName;
 private double price;
 private int quantity;

 public CartItem(String itemId, String itemName, double price, int quantity) {
     this.itemId = itemId;
     this.itemName = itemName;
     this.price = price;
     this.quantity = quantity;
 }

 public String getItemId() {
     return itemId;
 }

 public void setItemId(String itemId) {
     this.itemId = itemId;
 }

 public String getItemName() {
     return itemName;
 }

 public void setItemName(String itemName) {
     this.itemName = itemName;
 }

 public double getPrice() {
     return price;
 }

 public void setPrice(double price) {
     this.price = price;
 }

 public int getQuantity() {
     return quantity;
 }

 public void setQuantity(int quantity) {
     this.quantity = quantity;
 }
}
