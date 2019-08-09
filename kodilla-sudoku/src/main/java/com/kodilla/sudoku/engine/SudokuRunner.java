package com.kodilla.sudoku.engine;

import com.kodilla.sudoku.userinterface.UserInterface;

public class SudokuRunner {

    private final UserInterface userInterface;

    public SudokuRunner(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {
        boolean gameFinished = false;
        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame(userInterface);
            if (!theGame.play()) {
                gameFinished = userInterface.playAgain();
            }
        }
        userInterface.thankYou();
    }
}
