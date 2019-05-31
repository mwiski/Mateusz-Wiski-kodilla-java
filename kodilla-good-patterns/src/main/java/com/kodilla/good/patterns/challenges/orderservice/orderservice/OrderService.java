package com.kodilla.good.patterns.challenges.orderservice.orderservice;

import com.kodilla.good.patterns.challenges.orderservice.productorder.ProductOrder;

public interface OrderService {

    boolean order(ProductOrder productOrder);
}
