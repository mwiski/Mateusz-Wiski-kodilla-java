package com.kodilla.sudoku.userinterface;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuElement;

public interface UserInterface {

    void showIntro();

    void showInstruction();

    String getPlayerMove();

    SudokuElement getSudokuElement(String playerMove);

    void showBoard(SudokuBoard board);

    void wrongMove();

    boolean playAgain();

    boolean askAgain();

    void thankYou();
}
