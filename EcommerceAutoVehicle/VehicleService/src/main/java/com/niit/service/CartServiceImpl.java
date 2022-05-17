package com.niit.service;

import com.niit.domain.Cart;
import com.niit.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    private CartRepository cartRepository;
    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public List<Cart> getCartByUsername(String username) {
        return cartRepository.findByUsername(username);
    }

    @Override
    public boolean deleteCartById(String id) {
        cartRepository.deleteById(id);
        return true;
    }
}
