package com.niit.service;

import com.niit.domain.Cart;
import com.niit.domain.Vehicle;

import java.util.List;

public interface CartService {
    public Cart saveCart(Cart cart);
    public List<Cart> getAllCarts();
    public List<Cart> getCartByUsername(String Username);
    public boolean deleteCartById(String id);
}
