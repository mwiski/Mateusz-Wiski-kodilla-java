package com.kodilla.rps.round;

import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.model.RoundResult;

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

    public RoundResult checkIfResetOrExit(UserInterface gui, String playerMove) {
        if (playerMove.equals("n")) {
            return gui.resetGame();
        } else if (playerMove.equals("x")) {
            return gui.exitGame();
        } else {
            return null;
        }
    }
}