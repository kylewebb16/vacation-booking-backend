package com.d288.performanceassessment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "carts")
public class Cart {
    public Cart() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "package_price", precision = 19, scale = 2)
    private BigDecimal package_price;

    @Column(name = "party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItem;

    public void add(CartItem new_cart_item) {
        if (new_cart_item != null) {
            if (cartItem == null) {
                cartItem = new HashSet<>();
            }
            cartItem.add(new_cart_item);
            new_cart_item.setCart(this);
        }
    }
}
