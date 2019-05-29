package com.kodilla.good.patterns.challenges.orderservice.productorder;

import com.kodilla.good.patterns.challenges.orderservice.product.Product;
import com.kodilla.good.patterns.challenges.orderservice.user.User;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductOrder)) return false;
        ProductOrder that = (ProductOrder) o;
        return orderedQuantity == that.orderedQuantity &&
                user.equals(that.user) &&
                product.equals(that.product) &&
                orderId.equals(that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, product, orderId, orderedQuantity);
    }
}
