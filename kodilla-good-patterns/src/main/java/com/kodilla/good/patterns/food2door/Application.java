package com.kodilla.good.patterns.food2door;

import com.kodilla.good.patterns.food2door.order.OrderProcessor;
import com.kodilla.good.patterns.food2door.order.OrderRetriever;

public class Application {

    public static void main(String[] args) {

        OrderRetriever retriever = new OrderRetriever();
        OrderProcessor processor = new OrderProcessor();

        processor.order(retriever.retrieveExtraFoodShopOrder());
        System.out.println(retriever.getProductQuantity(retriever.getExtraFoodShop()));

        processor.order(retriever.retrieveHealthyShopOrder());
        System.out.println(retriever.getProductQuantity(retriever.getHealthyShop()));

        processor.order(retriever.retrieveGlutenFreeShopOrder());
        System.out.println(retriever.getProductQuantity(retriever.getGlutenFreeShop()));
    }
}
