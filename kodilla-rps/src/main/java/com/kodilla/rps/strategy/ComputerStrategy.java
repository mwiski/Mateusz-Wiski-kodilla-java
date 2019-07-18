package com.kodilla.rps.strategy;

import com.kodilla.rps.shapes.Shape;
import com.kodilla.rps.shapes.Shapes;
import java.util.Random;

public class ComputerStrategy {

    private Random random = new Random();

    public Shape move() {
        return Shapes.SHAPES.get(random.nextInt(3));
    }
}
