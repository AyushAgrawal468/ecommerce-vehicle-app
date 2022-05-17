package com.niit.controller;

import com.niit.domain.Cart;
import com.niit.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CartController {
    private CartService cartService;
    private ResponseEntity responseEntity;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart")
    public ResponseEntity<?> saveCart(@RequestBody Cart cart)
    {
        cartService.saveCart(cart);
        responseEntity = new ResponseEntity<>(cart, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/carts")
    public ResponseEntity<?> getAllCarts()
    {
        responseEntity=new ResponseEntity(cartService.getAllCarts(),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/cart/{username}")
    public ResponseEntity<?> getCartByUsername(@PathVariable String username)
    {
        responseEntity=new ResponseEntity(cartService.getCartByUsername(username),HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/cart/delete/{id}")
    public ResponseEntity<?> deleteCartById(@PathVariable String id)
    {
        cartService.deleteCartById(id);
        responseEntity = new ResponseEntity("Successfully Deleted/Removed",HttpStatus.OK);
        return responseEntity;
    }
}
