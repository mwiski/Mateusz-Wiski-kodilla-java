package com.kodilla.good.patterns.food2door.product;

import java.util.Objects;

public class Cranberry implements Product {

    private String name;
    private int quantity;

    public Cranberry(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
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
        if (!(o instanceof Cranberry)) return false;
        Cranberry cranberry = (Cranberry) o;
        return quantity == cranberry.quantity &&
                name.equals(cranberry.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }
}
