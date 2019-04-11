package com.kodilla.testing.forum.shape;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public String getShapeName() {
        return "square";
    }

    public double getField() {
        return sideLength * sideLength;
    }

    @Override
    public String toString() {
        return "Square{sideLength=" + sideLength + "}";
    }
}
