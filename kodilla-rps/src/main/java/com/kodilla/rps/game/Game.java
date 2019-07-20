package com.kodilla.rps.game;

import com.kodilla.rps.shapes.Shape;
import com.kodilla.rps.strategy.Strategy;

public class Game {

    private Strategy strategy;
    private Shape userShape;

    public Game() {
        this.strategy = new Strategy();
    }

    public void start() {

    }

    public void setUserShape(Shape userShape) {
        this.userShape = userShape;
    }
}
