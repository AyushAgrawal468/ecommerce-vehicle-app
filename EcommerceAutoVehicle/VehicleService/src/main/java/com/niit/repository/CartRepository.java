package com.niit.repository;

import com.niit.domain.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CartRepository extends MongoRepository<Cart,String> {
    public List<Cart> findByUsername(String Username);
}
