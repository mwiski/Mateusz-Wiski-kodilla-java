package com.kodilla.rps.strategy;

import com.kodilla.rps.model.Move;

import java.util.Random;

public class ComputerStrategy implements Strategy {

    private Move computerMove;
    private static Random random = new Random();

    public Move getMove() {
        return computerMove = Move.get(random.nextInt(3));
    }

    public Move getComputerMove() {
        return computerMove;
    }
}
