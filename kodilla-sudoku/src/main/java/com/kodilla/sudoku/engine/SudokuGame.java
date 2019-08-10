package com.kodilla.sudoku.engine;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuElement;
import com.kodilla.sudoku.board.SudokuRow;
import com.kodilla.sudoku.validator.SudokuValidator;
import com.kodilla.sudoku.userinterface.UserInterface;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SudokuGame {

    private static final int BOARD_SIZE = 9;
    private static final int BLOCK_SIZE = 3;
    private static Random random = new Random();
    private static List<Integer> possibleValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private final static SudokuElement RESOLVE_SUDOKU = new SudokuElement(-1, -1);
    private final UserInterface userInterface;
    private SudokuBoard board;
    private SudokuValidator validator;

    public SudokuGame(UserInterface userInterface) {
        this.userInterface = userInterface;
        this.board = new SudokuBoard(BOARD_SIZE, BLOCK_SIZE);
        this.validator = new SudokuValidator(board);
    }

    public boolean play() {
        userInterface.showIntro();
        userInterface.showBoard(board);
        SudokuElement element = new SudokuElement(0, 0);

        while (element != RESOLVE_SUDOKU) {
            element = userInterface.getPlayerMove();
            if (validator.validate(element)) {
                board.addPlayerMove(element);
            } else {
                userInterface.wrongMove();
            }
            userInterface.showBoard(board);
        }
        resolveSudoku();
        return false;
    }

    public void resolveSudoku() {
        for (SudokuRow row : board.getRows()) {
            for (SudokuElement element : row.getRowElements()) {
                if (element.getValue() != SudokuElement.EMPTY) {
                    element.setValue(random.nextInt(BOARD_SIZE) + 1);
                    if (validator.validate(element)) {
                        board.addPlayerMove(element);
                    } else {
                        resolveSudoku();
                    }
                }
            }
        }
    }
}
