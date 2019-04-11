package com.kodilla.testing.forum.shape;

public class Circle implements Shape {
    final double PI = 3.14;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getShapeName() {
        return "circle";
    }

    public double getField() {
        return PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle {radius= " + radius + "}";
    }
}
