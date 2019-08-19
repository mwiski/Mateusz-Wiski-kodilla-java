package com.kodilla.sudoku.engine;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuElement;
import com.kodilla.sudoku.board.SudokuRow;
import com.kodilla.sudoku.checker.SudokuChecker;
import com.kodilla.sudoku.userinterface.UserInterface;

public class SudokuGame {

    private static final int BLOCK_SIZE = 3;
    private static final int BOARD_SIZE = BLOCK_SIZE * BLOCK_SIZE;
    private static final int MIN_SIZE = 1;
    private final UserInterface userInterface;
    private SudokuBoard board;
    private SudokuChecker checker;

    public SudokuGame(UserInterface userInterface) {
        this.userInterface = userInterface;
        this.board = new SudokuBoard.Builder().board(BOARD_SIZE, BLOCK_SIZE).build();
        this.checker = new SudokuChecker(board);
    }

    public boolean play() {
        userInterface.showIntro();
        userInterface.showBoard(board);
        String playerMove;
        while (!shouldResolve(playerMove = userInterface.getPlayerMove())) {
            SudokuElement element = userInterface.getSudokuElement(playerMove);
            if (checker.canBeAddedToBoard(element)) {
                board.addPlayerMove(element);
            } else {
                userInterface.wrongMove();
            }
            userInterface.showBoard(board);
        }
        resolveSudoku();
        userInterface.showBoard(board);
        return false;
    }

    private boolean shouldResolve(String playerMove) {
        return playerMove.equals("SUDOKU");
    }

    private boolean resolveSudoku() {
        for (SudokuRow row : board.getRows()) {
            for (SudokuElement element : row.getRowElements()) {
                if (element.getValue() == SudokuElement.EMPTY) {
                    SudokuElement newElement = new SudokuElement(element.getX(), element.getY());
                    for (int n = MIN_SIZE; n <= BOARD_SIZE; n++) {
                        newElement.setValue(n);
                        if (checker.canBeAddedToBoard(newElement)) {
                            board.addPlayerMove(newElement);
                            if (resolveSudoku()) {
                                return true;
                            } else {
                                element.setValue(SudokuElement.EMPTY);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
