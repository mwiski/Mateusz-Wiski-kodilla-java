package com.kodilla.good.patterns.challenges.orderservice.product;

public class Toothbrush implements Product {

    private String name;
    private String id;
    private int availableQuantity;

    public Toothbrush(String name, String id, int availableQuantity) {
        this.name = name;
        this.id = id;
        this.availableQuantity = availableQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void decreaseQuantity() {
        availableQuantity--;
    }
}
