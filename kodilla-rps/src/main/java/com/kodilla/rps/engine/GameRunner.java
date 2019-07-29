package com.kodilla.rps.engine;

import com.kodilla.rps.gui.UserInterface;

public class GameRunner {

    private final UserInterface userInterface;

    public GameRunner(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {
        Game game = new Game(userInterface);
        game.start();
    }
}
