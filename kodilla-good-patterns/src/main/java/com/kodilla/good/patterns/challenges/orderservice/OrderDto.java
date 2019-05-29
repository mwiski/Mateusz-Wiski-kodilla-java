package com.kodilla.good.patterns.challenges.orderservice;

import com.kodilla.good.patterns.challenges.orderservice.product.Product;
import com.kodilla.good.patterns.challenges.orderservice.user.User;

public class OrderDto {

    private User user;
    private Product product;
    private String orderId;
    private int orderedQuantity;
    private boolean isOrdered;

    public OrderDto(User user, Product product, String orderId, int orderedQuantity, boolean isOrdered) {
        this.user = user;
        this.product = product;
        this.orderId = orderId;
        this.orderedQuantity = orderedQuantity;
        this.isOrdered = isOrdered;
    }
}
