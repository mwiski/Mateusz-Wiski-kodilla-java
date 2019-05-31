package com.kodilla.good.patterns.food2door.order;

import com.kodilla.good.patterns.food2door.product.Bread;
import com.kodilla.good.patterns.food2door.purchaser.Purchaser;
import com.kodilla.good.patterns.food2door.foodproducer.ExtraFoodShop;
import com.kodilla.good.patterns.food2door.foodproducer.GlutenFreeShop;
import com.kodilla.good.patterns.food2door.foodproducer.HealthyShop;
import com.kodilla.good.patterns.food2door.product.Cranberry;
import com.kodilla.good.patterns.food2door.product.Juice;

public class OrderRetriever {

    private Order orderExtra;
    private Order orderHealthy;
    private Order orderGlutenFree;

    public Order retrieveExtraFoodShopOrder() {

        Purchaser purchaser = new Purchaser("Jan", "Kowalski", "SimpleStreet");
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        Cranberry cranberry = new Cranberry("Dried cranberry", 10);

        return orderExtra = new Order(purchaser, extraFoodShop, cranberry, 5, "001a");
    }

    public Order retrieveHealthyShopOrder() {

        Purchaser purchaser = new Purchaser("Jan", "Kowalski", "SimpleStreet");
        HealthyShop healthyShop = new HealthyShop();
        Juice juice = new Juice("Orangejuice", 8, 1);
        healthyShop.addProduct(juice);

        return orderHealthy = new Order(purchaser, healthyShop, juice, 8, "001b");
    }

    public Order retrieveGlutenFreeShopOrder() {

        Purchaser purchaser = new Purchaser("Jan", "Kowalski", "SimpleStreet");
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop(10);
        Bread bread = new Bread("Gluten-free bread", 8, 1);

        return orderGlutenFree = new Order(purchaser, glutenFreeShop, bread, 8, "001c");
    }

    public Order getOrderExtra() {
        return orderExtra;
    }

    public Order getOrderHealthy() {
        return orderHealthy;
    }

    public Order getOrderGlutenFree() {
        return orderGlutenFree;
    }
}
