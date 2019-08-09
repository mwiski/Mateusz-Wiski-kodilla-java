package com.kodilla.sudoku.engine;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuElement;
import com.kodilla.sudoku.userinterface.UserInterface;

public class SudokuGame {

    private static final int BOARD_SIZE = 9;
    private static final int BLOCK_SIZE = 3;
    private final static SudokuElement RESOLVE_SUDOKU = new SudokuElement(-1, -1);
    private final UserInterface userInterface;
    private SudokuBoard board;

    public SudokuGame(UserInterface userInterface) {
        this.userInterface = userInterface;
        this.board = new SudokuBoard(BOARD_SIZE, BLOCK_SIZE);
    }

    public boolean play() {
        userInterface.showIntro();
        userInterface.showBoard(board);
        SudokuElement element = new SudokuElement(0, 0);

        while (element != RESOLVE_SUDOKU) {
            element = userInterface.getPlayerMove();
            if (!board.addPlayerMove(element)) {
                userInterface.wrongMove();
            }
            userInterface.showBoard(board);
        }
        resolveSudoku();
        return false;
    }

    public void resolveSudoku() {
        //Implement method body
    }
}
