package com.kodilla.rps.strategy;

import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.model.Move;

public class PlayerStrategy implements Strategy {

    private Move playerMove;
    private String playerInput;

    public String scanMove(UserInterface gui) {
        return playerInput = gui.scanPlayerMove();
    }
    
    public Move getMove() {
        switch (playerInput) {
            case "1": {
                return playerMove = Move.ROCK;
            }
            case "2": {
                return playerMove = Move.PAPER;
            }
            case "3": {
                return playerMove = Move.SCISSORS;
            }
            default: {
                return getMove();
            }
        }
    }

    public Move getPlayerMove() {
        return playerMove;
    }

    public String getPlayerInput() {
        return playerInput;
    }
}