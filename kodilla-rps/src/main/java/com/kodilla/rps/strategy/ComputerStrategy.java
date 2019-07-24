package com.kodilla.rps.strategy;

import com.kodilla.rps.model.Shape;
import java.util.Random;

public class ComputerStrategy {

    private static Random random = new Random();

    public Shape getShape() {
        return Shape.get(random.nextInt(3));
    }
}
