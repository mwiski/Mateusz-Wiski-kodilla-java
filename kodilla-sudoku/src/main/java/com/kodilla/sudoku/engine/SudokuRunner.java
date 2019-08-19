package com.kodilla.sudoku.engine;

import com.kodilla.sudoku.userinterface.UserInterface;

public class SudokuRunner {

    private final UserInterface userInterface;

    public SudokuRunner(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {
        boolean shouldGameEnd = false;
        while(!shouldGameEnd) {
            SudokuGame theGame = new SudokuGame(userInterface);
            if (!theGame.play()) {
                shouldGameEnd = userInterface.playAgain();
            }
        }
        userInterface.thankYou();
    }
}
