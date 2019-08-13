package com.kodilla.good.patterns.food2door.product;

import java.util.Objects;

public class Bread implements Product {

    private String name;
    private int quantity;
    private double weight;

    public Bread(String name, int quantity, double weight) {
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public int decreaseQuantity(int orderedQuantity) {
        return quantity -= orderedQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bread)) return false;
        Bread bread = (Bread) o;
        return quantity == bread.quantity &&
                Double.compare(bread.weight, weight) == 0 &&
                name.equals(bread.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, weight);
    }
}
