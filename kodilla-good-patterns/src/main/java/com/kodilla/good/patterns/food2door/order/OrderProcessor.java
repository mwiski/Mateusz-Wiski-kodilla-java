package com.kodilla.good.patterns.food2door.order;

public class OrderProcessor {

    public OrderDto order(Order order) {

        boolean isOrdered = order.getFoodProducer().process(order.getProduct(), order.getQuantity());

        if (isOrdered) {
            return new OrderDto(order.getPurchaser(), order.getFoodProducer(), order.getProduct(), order.getQuantity(), order.getOrderId(), true);
        } else {
            return new OrderDto(order.getPurchaser(), order.getFoodProducer(), order.getProduct(), order.getQuantity(), order.getOrderId(), false);
        }
    }
}
