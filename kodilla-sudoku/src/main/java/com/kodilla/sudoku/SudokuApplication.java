package com.kodilla.sudoku;

import com.kodilla.sudoku.engine.SudokuRunner;
import com.kodilla.sudoku.userinterface.SimpleUserInterface;

public class SudokuApplication {

    public static void main(String[] args) {
        SudokuRunner sudokuRunner = new SudokuRunner(new SimpleUserInterface());
        sudokuRunner.run();
    }
}
