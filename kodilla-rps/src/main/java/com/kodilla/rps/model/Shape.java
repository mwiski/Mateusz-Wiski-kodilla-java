package com.kodilla.rps.model;

public enum Shape {

    ROCK,
    PAPER,
    SCISSORS;

    public static Shape get(int index) {
        if (index < Shape.values().length) {
            return Shape.values()[index];
        } else {
            throw new IllegalStateException("Invalid index for Shape");
        }
    }
}
