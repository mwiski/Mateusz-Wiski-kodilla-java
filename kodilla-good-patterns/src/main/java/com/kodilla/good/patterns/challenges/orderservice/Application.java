package com.kodilla.good.patterns.challenges.orderservice;

import com.kodilla.good.patterns.challenges.orderservice.informationservice.MailService;
import com.kodilla.good.patterns.challenges.orderservice.orderrepository.ProductOrderRepository;
import com.kodilla.good.patterns.challenges.orderservice.processor.OrderProcessor;
import com.kodilla.good.patterns.challenges.orderservice.productorder.ProductOrderRetriever;
import com.kodilla.good.patterns.challenges.orderservice.orderservice.ProductOrderService;

public class Application {

    public static void main(String[] args) {

        ProductOrderRetriever retriever = new ProductOrderRetriever();
        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new ProductOrderService(), new ProductOrderRepository());

        orderProcessor.process(retriever.retrieve());
        System.out.println(retriever.getProductOrder().getProduct().getAvailableQuantity());
    }
}
