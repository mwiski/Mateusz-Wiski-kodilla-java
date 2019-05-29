package com.kodilla.good.patterns.challenges.orderservice.orderservice;

import com.kodilla.good.patterns.challenges.orderservice.productorder.ProductOrder;

public class ProductOrderService implements OrderService {

    public boolean order(ProductOrder productOrder) {
        if (productOrder.getProduct().getAvailableQuantity() > 0) {
            productOrder.getProduct().decreaseQuantity();
            return true;
        }
        return false;
    }
}
