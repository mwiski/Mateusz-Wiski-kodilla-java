package com.kodilla.good.patterns.food2door.product;

import java.util.Objects;

public class Juice implements Product {

    private String name;
    private int quantity;
    private double volume;

    public Juice(String name, int quantity, double volume) {
        this.name = name;
        this.quantity = quantity;
        this.volume = volume;
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
        if (!(o instanceof Juice)) return false;
        Juice juice = (Juice) o;
        return quantity == juice.quantity &&
                Double.compare(juice.volume, volume) == 0 &&
                name.equals(juice.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, volume);
    }
}
