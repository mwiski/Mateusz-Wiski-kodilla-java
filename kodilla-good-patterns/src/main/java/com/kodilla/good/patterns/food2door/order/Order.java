package com.kodilla.good.patterns.food2door.order;

import com.kodilla.good.patterns.food2door.purchaser.Purchaser;
import com.kodilla.good.patterns.food2door.foodproducer.FoodProducer;
import com.kodilla.good.patterns.food2door.product.Product;
import java.util.Objects;

public class Order {

    private Purchaser purchaser;
    private FoodProducer foodProducer;
    private Product product;
    private int quantity;
    private String orderId;

    public Order(Purchaser purchaser, FoodProducer foodProducer, Product product, int quantity, String orderId) {
        this.purchaser = purchaser;
        this.foodProducer = foodProducer;
        this.product = product;
        this.quantity = quantity;
        this.orderId = orderId;
    }

    Purchaser getPurchaser() {
        return purchaser;
    }

    FoodProducer getFoodProducer() {
        return foodProducer;
    }

    public Product getProduct() {
        return product;
    }

    int getQuantity() {
        return quantity;
    }

    String getOrderId() {
        return orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return orderId.equals(order.orderId) &&
                quantity == order.quantity &&
                purchaser.equals(order.purchaser) &&
                product.equals(order.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaser, orderId, product, quantity);
    }
}
