package com.d288.performanceassessment.service;

import com.d288.performanceassessment.entity.Cart;
import com.d288.performanceassessment.entity.CartItem;
import com.d288.performanceassessment.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}
