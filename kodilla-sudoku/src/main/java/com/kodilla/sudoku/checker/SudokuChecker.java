package com.kodilla.sudoku.checker;

import com.kodilla.sudoku.board.*;

public class SudokuChecker {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private SudokuBoard board;

    public SudokuChecker(SudokuBoard board) {
        this.board = board;
    }

    public boolean check(SudokuElement element) {
        if (!checkElement(element)) {
            return false;
        } else if (!checkRow(element)) {
            return false;
        } else if (!checkColumn(element)) {
            return false;
        } else return checkBlock(element);
    }

    private boolean checkElement(SudokuElement element) {
        return element.getX() > MIN_VALUE && element.getX() < MAX_VALUE && element.getY() > MIN_VALUE && element.getY() < MAX_VALUE;
    }

    private boolean checkRow(SudokuElement element) {
        SudokuRow row = board.getRows().get(element.getX());
        for (SudokuElement sudokuElement : row.getRowElements()) {
            if (sudokuElement.getValue() == element.getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(SudokuElement element) {
        SudokuColumn column = board.getColumns().get(element.getY());
        for (SudokuElement sudokuElement : column.getColumnElements()) {
            if (sudokuElement.getValue() == element.getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBlock(SudokuElement element) {
        for (SudokuBlock block : board.getBlocks()) {
            for (SudokuElement sudokuElement : block.getBlockElements()) {
                if (sudokuElement.getValue() == element.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
