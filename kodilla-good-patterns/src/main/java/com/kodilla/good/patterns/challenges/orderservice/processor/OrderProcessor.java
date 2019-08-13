package com.kodilla.good.patterns.challenges.orderservice.processor;

import com.kodilla.good.patterns.challenges.orderservice.OrderDto;
import com.kodilla.good.patterns.challenges.orderservice.informationservice.InformationService;
import com.kodilla.good.patterns.challenges.orderservice.orderrepository.OrderRepository;
import com.kodilla.good.patterns.challenges.orderservice.orderservice.OrderService;
import com.kodilla.good.patterns.challenges.orderservice.productorder.ProductOrder;

public class OrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(final InformationService informationService,
                          final OrderService orderService,
                          final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final ProductOrder productOrder) {
        boolean isOrdered = orderService.order(productOrder);

        if (isOrdered) {
            informationService.inform(productOrder.getUser());
            orderRepository.createOrder(productOrder);
            return new OrderDto(productOrder.getUser(), productOrder.getProduct(), productOrder.getOrderId(), productOrder.getOrderedQuantity(), true);
        } else {
            return new OrderDto(productOrder.getUser(), productOrder.getProduct(), productOrder.getOrderId(), productOrder.getOrderedQuantity(), false);
        }
    }
}

