package com.d288.performanceassessment.service;

import com.d288.performanceassessment.dao.CartRepository;
import com.d288.performanceassessment.dao.CustomerRepository;
import com.d288.performanceassessment.entity.Cart;
import com.d288.performanceassessment.entity.CartItem;
import com.d288.performanceassessment.entity.Customer;
import com.d288.performanceassessment.entity.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        Customer customer = purchase.getCustomer();
        customer.add(cart);

        cart.setStatus(StatusType.ordered);


        if (cart.getCartItem() != null && !cart.getCartItem().isEmpty()) {
            cartRepository.save(cart);
            return new PurchaseResponse(orderTrackingNumber);
        }
        else {
            return new PurchaseResponse("Cart can not be empty, please add items to checkout");
        }
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
