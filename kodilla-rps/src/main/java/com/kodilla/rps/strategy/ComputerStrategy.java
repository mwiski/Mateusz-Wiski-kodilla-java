package com.kodilla.rps.strategy;

import com.kodilla.rps.model.Move;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ComputerStrategy implements Strategy {

    private static final List<Move> COMPUTER_MOVES = Arrays.asList(Move.ROCK, Move.PAPER, Move.SCISSORS);
    private Move computerMove;
    private static Random random = new Random();

    public Move getMove() {
        return computerMove = COMPUTER_MOVES.get(random.nextInt(COMPUTER_MOVES.size()));
    }

    public Move getComputerMove() {
        return computerMove;
    }
}
