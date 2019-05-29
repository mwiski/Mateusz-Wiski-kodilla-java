package com.kodilla.good.patterns.challenges.orderservice.orderrepository;

import com.kodilla.good.patterns.challenges.orderservice.productorder.ProductOrder;
import java.util.List;

public class ProductOrderRepository implements OrderRepository {

    private List<ProductOrder> productOrders;

    public ProductOrderRepository(List<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

    public boolean createOrder(ProductOrder productOrder) {
        productOrders.add(productOrder);
        return true;
    }
}
