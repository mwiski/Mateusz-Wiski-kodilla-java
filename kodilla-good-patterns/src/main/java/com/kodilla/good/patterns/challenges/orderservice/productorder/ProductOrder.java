package com.kodilla.good.patterns.challenges.orderservice.productorder;

import com.kodilla.good.patterns.challenges.orderservice.product.Product;
import com.kodilla.good.patterns.challenges.orderservice.user.User;

public class ProductOrder {

    private User user;
    private Product product;
    private String orderId;
    private int orderedQuantity;

    public ProductOrder(User user, Product product, String orderId, int orderedQuantity) {
        this.user = user;
        this.product = product;
        this.orderId = orderId;
        this.orderedQuantity = orderedQuantity;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }
}
