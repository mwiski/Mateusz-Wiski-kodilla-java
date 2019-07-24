package com.kodilla.rps.round;

import com.kodilla.rps.model.Shape;

public class RoundChecker {

    private Shape compare(Shape userShape, Shape computerShape) {
        if (userShape.equals(computerShape)) {
            return null;
        }

        switch (userShape) {
            case ROCK: {
                if (computerShape.equals(Shape.PAPER)) {
                    return computerShape;
                }
                return userShape;
            }
            case PAPER: {
                if (computerShape.equals(Shape.SCISSORS)) {
                    return computerShape;
                }
                return userShape;
            }
            case SCISSORS: {
                if (computerShape.equals(Shape.ROCK)) {
                    return computerShape;
                }
                return userShape;
            }
            default: {
                throw new IllegalArgumentException("User shape is not correct.");
            }
        }
    }
}
