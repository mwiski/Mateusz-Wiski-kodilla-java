package com.kodilla.rps;

import com.kodilla.rps.engine.GameRunner;
import com.kodilla.rps.gui.SimpleUserInterface;

public class RpsApplication {

    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner(new SimpleUserInterface());
        gameRunner.run();
    }
}
