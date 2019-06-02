package com.kodilla.good.patterns.food2door.order;

import com.kodilla.good.patterns.food2door.purchaser.Purchaser;
import com.kodilla.good.patterns.food2door.foodproducer.FoodProducer;
import com.kodilla.good.patterns.food2door.product.Product;

public class OrderDto {

    private Purchaser purchaser;
    private FoodProducer foodProducer;
    private Product product;
    private int quantity;
    private String orderId;
    private boolean isOrdered;

    public OrderDto(Purchaser purchaser, FoodProducer foodProducer, Product product, int quantity, String orderId, boolean isOrdered) {
        this.purchaser = purchaser;
        this.foodProducer = foodProducer;
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.isOrdered = isOrdered;
    }

    public Purchaser getPurchaser() {
        return purchaser;
    }

    public FoodProducer getFoodProducer() {
        return foodProducer;
    }

    public String getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
