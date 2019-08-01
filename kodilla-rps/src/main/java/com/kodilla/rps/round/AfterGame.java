package com.kodilla.rps.round;

import com.kodilla.rps.engine.Game;
import com.kodilla.rps.model.GameResult;

public class AfterGame {

    public void next(GameResult gameResult, Game game) {
        switch (gameResult) {
            case EXIT: {
                System.exit(0);
            }
            case RESET: {
                game.start();
            }
        }
    }
}
