package com.niit.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.util.List;

@Document
public class Cart {

    @Id
    String cartId;
    String username;
    Vehicle vehicle;

    public Cart() {
    }

    public Cart(String cartId, String username, Vehicle vehicle) {
        this.cartId = cartId;
        this.username = username;
        this.vehicle = vehicle;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", username='" + username + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
