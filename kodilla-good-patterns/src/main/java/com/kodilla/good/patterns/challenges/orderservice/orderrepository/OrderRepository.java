package com.kodilla.good.patterns.challenges.orderservice.orderrepository;

import com.kodilla.good.patterns.challenges.orderservice.productorder.ProductOrder;

public interface OrderRepository {

    boolean createOrder(ProductOrder productOrder);
}
