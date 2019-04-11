package com.kodilla.testing.forum.shape;

public class Triangle implements Shape{
    private double sideLength;
    private double height;

    public Triangle(double sideLength, double height) {
        this.sideLength = sideLength;
        this.height = height;
    }

    public String getShapeName() {
        return "triangle";
    }

    public double getField() {
        return 0.5 * sideLength * height;
    }

    @Override
    public String toString() {
        return "Triangle {sideLength= " + sideLength + ", height= " + height + "}";
    }
}
