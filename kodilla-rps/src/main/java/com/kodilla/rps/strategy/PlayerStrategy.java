package com.kodilla.rps.strategy;

import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.model.Move;

public class PlayerStrategy implements Strategy {

    private final UserInterface gui;
    private Move playerMove;

    public PlayerStrategy(UserInterface gui) {
        this.gui = gui;
    }

    public Move getMove() {
        return playerMove = gui.getPlayerMove();
    }

    public Move getPlayerMove() {
        return playerMove;
    }
}
