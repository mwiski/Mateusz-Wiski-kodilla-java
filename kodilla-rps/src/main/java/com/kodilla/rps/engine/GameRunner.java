package com.kodilla.rps.engine;

import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.model.GameResult;

public class GameRunner {

    private final UserInterface userInterface;

    public GameRunner(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {
        Game game = null;
        boolean shouldEnd = false;
        while (!shouldEnd) {
            game = new Game(userInterface);
            GameResult result = game.start();
            if (result == GameResult.EXIT) {
                shouldEnd = userInterface.confirmOnceAgain();
            }
        }
        userInterface.thankYou(game.getUsername());
    }
}
