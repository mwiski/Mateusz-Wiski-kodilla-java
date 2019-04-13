package com.kodilla.testing.forum.shape;

import java.util.Objects;

public class Square implements Shape {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public String getName() {
        return "square";
    }

    public double getField() {
        return length * length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }
}
