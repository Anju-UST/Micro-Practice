package com.ust.CartService.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ust.CartService.model.CartItem;
import com.ust.CartService.model.CartModel;
import com.ust.CartService.repository.CartRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;
import java.util.Optional;

    @RestController
    @RequestMapping("/cart")
    public class CartController {
        @Autowired
        private CartRepo crepo;
        @Autowired 
        RestTemplate template;

        @PostMapping("/addtocart")
        public ResponseEntity<CartModel> create(@RequestBody CartModel add){
        	String url="http://localhost:6000/products/get/{id}";
    		String output=template.getForObject(url, String.class);
    		ObjectMapper objectMapper = new ObjectMapper();
    		Product product = objectMapper.readValue(output, Product.class);
    		CartItem cartItem = new CartItem();
    		cartItem.setProductId(output.getId());
    		cartItem.setProductName(output.getName());
    		cartItem.setPrice(output.getPrice());
    		cartItem.setImage(output.getImage());
    		add.getItems().add(cartItem);

            crepo.save(add);

            return ResponseEntity.ok().body(add);
        }

        @GetMapping("/get/{id}")
        public ResponseEntity<CartModel> getproductbyid(@PathVariable Integer id){
            Optional<CartModel> rate = crepo.findById(id);
            if (rate.isPresent()) {
                return ResponseEntity.ok().body(crepo.findById(id).orElse(null));
            } else {
                return ResponseEntity.noContent().build();
            }


        }


        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Boolean> deleteproduct(@PathVariable Integer id){
            crepo.deleteById(id);
            return ResponseEntity.ok(null);

        }
        @PostMapping("/order")
        public Long placeOrder(){
        String url="http://localhost:9091/order/placeorder";
		ResponseEntity<Long> response= template.getForEntity(url, long.class);
		 Long productsJson = response.getBody();
		 return productsJson;
    }
  }


