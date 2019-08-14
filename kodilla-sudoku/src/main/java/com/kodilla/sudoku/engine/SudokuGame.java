package com.kodilla.sudoku.engine;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuElement;
import com.kodilla.sudoku.board.SudokuRow;
import com.kodilla.sudoku.checker.SudokuChecker;
import com.kodilla.sudoku.userinterface.UserInterface;
import java.util.Random;

public class SudokuGame {

    private static final int BOARD_SIZE = 9;
    private static final int BLOCK_SIZE = 3;
    private static final Random random = new Random();
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
        while (!(playerMove = userInterface.getPlayerMove()).equals("SUDOKU")) {
            SudokuElement element = userInterface.getSudokuElement(playerMove);
            if (checker.checkIfMoveCanBeAdded(element)) {
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

    private void resolveSudoku() {
        for (SudokuRow row : board.getRows()) {
            for (SudokuElement element : row.getRowElements()) {
                SudokuElement newElement = new SudokuElement(element.getX(), element.getY());
                while (element.getValue() == SudokuElement.EMPTY) {
                    newElement.setValue(random.nextInt(BOARD_SIZE) + 1);
                    if (checker.checkIfMoveCanBeAdded(newElement)) {
                        board.addPlayerMove(newElement);
                    }
                }
            }
        }
    }
}
