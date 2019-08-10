package com.kodilla.sudoku.userinterface;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuElement;

public interface UserInterface {

    void showIntro();

    void showInstruction();

    SudokuElement getPlayerMove();

    void showBoard(SudokuBoard board);

    boolean validate(String playerMove);

    void wrongInput();

    void wrongMove();

    boolean playAgain();

    boolean askAgain();

    void thankYou();
}
