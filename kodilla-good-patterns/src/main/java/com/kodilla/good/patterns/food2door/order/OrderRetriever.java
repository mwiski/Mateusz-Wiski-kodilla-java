package com.kodilla.good.patterns.food2door.order;

import com.kodilla.good.patterns.food2door.foodproducer.FoodProducer;
import com.kodilla.good.patterns.food2door.product.Bread;
import com.kodilla.good.patterns.food2door.purchaser.Purchaser;
import com.kodilla.good.patterns.food2door.foodproducer.ExtraFoodShop;
import com.kodilla.good.patterns.food2door.foodproducer.GlutenFreeShop;
import com.kodilla.good.patterns.food2door.foodproducer.HealthyShop;
import com.kodilla.good.patterns.food2door.product.Cranberry;
import com.kodilla.good.patterns.food2door.product.Juice;

public class OrderRetriever {

    private ExtraFoodShop extraFoodShop;
    private HealthyShop healthyShop;
    private GlutenFreeShop glutenFreeShop;

    public OrderRetriever() {
        this.extraFoodShop = new ExtraFoodShop();
        this.healthyShop = new HealthyShop();
        this.glutenFreeShop = new GlutenFreeShop(10);
    }

    public Order retrieveExtraFoodShopOrder() {

        Purchaser purchaser = new Purchaser("Jan", "Kowalski", "SimpleStreet");
        Cranberry cranberry = new Cranberry("Dried cranberry", 10);

        return new Order(purchaser, extraFoodShop, cranberry, 5, "001a");
    }

    public Order retrieveHealthyShopOrder() {

        Purchaser purchaser = new Purchaser("Jan", "Kowalski", "SimpleStreet");
        Juice juice = new Juice("Orangejuice", 8, 1);
        healthyShop.addProduct(juice);

        return new Order(purchaser, healthyShop, juice, 8, "001b");
    }

    public Order retrieveGlutenFreeShopOrder() {

        Purchaser purchaser = new Purchaser("Jan", "Kowalski", "SimpleStreet");
        Bread bread = new Bread("Gluten-free bread", 8, 1);

        return new Order(purchaser, glutenFreeShop, bread, 8, "001c");
    }

    public ExtraFoodShop getExtraFoodShop() {
        return extraFoodShop;
    }

    public HealthyShop getHealthyShop() {
        return healthyShop;
    }

    public GlutenFreeShop getGlutenFreeShop() {
        return glutenFreeShop;
    }

    public int getProductQuantity(FoodProducer foodProducer) {
        return foodProducer.getProduct().getQuantity();
    }
}
