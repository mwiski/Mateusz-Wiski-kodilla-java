package com.kodilla.good.patterns.challenges.orderservice.product;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toothbrush)) return false;
        Toothbrush that = (Toothbrush) o;
        return name.equals(that.name) &&
                id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
