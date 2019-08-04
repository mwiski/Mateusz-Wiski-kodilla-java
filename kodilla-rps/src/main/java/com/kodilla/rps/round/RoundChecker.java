package com.kodilla.rps.round;

import com.kodilla.rps.model.Move;
import com.kodilla.rps.model.RoundResult;

public class RoundChecker {

    RoundResult compareMoves(Move playerMove, Move computerMove) {
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
            case RESET: {
                return RoundResult.RESET;
            }
            case EXIT: {
                return RoundResult.EXIT;
            }
            default: {
                throw new IllegalArgumentException("Player move is not correct.");
            }
        }
    }
}
