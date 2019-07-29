package com.kodilla.rps.round;

import com.kodilla.rps.model.Move;
import com.kodilla.rps.statistics.RoundResult;

public class RoundChecker {

    public RoundResult compare(Move playerMove, Move computerMove) {
        if (playerMove.equals(computerMove)) {
            return RoundResult.DRAW;
        }

        switch (playerMove) {
            case ROCK: {
                if (computerMove.equals(Move.PAPER)) {
                    return RoundResult.LOSE;
                }
                return RoundResult.WIN;
            }
            case PAPER: {
                if (computerMove.equals(Move.SCISSORS)) {
                    return RoundResult.LOSE;
                }
                return RoundResult.WIN;
            }
            case SCISSORS: {
                if (computerMove.equals(Move.ROCK)) {
                    return RoundResult.LOSE;
                }
                return RoundResult.WIN;
            }
            default: {
                throw new IllegalArgumentException("Player move is not correct.");
            }
        }
    }

    public RoundResult checkIfEndOrExit(String playerMove) {
        if (playerMove.equals("n")) {
            return RoundResult.END;
        } else if (playerMove.equals("x")) {
            return RoundResult.EXIT;
        } else {
            return null;
        }
    }
}
