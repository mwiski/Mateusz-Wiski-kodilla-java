package com.kodilla.sudoku.checker;

import com.kodilla.sudoku.board.*;

public class SudokuChecker {

    private SudokuBoard board;

    public SudokuChecker(SudokuBoard board) {
        this.board = board;
    }

    public boolean checkIfMoveCanBeAdded(SudokuElement element) {
        if (!checkIfElementIsEmpty(element)) {
            return false;
        }
        if (!checkIfCanBeAddedToRow(element)) {
            return false;
        } else if (!checkIfCanBeAddedToColumn(element)) {
            return false;
        } else return checkIfCanBeAddedToBlock(element);
    }

    private boolean checkIfElementIsEmpty(SudokuElement element) {
        return board.getRows().get(element.getX()).getElement(element.getY()).getValue() == SudokuElement.EMPTY;
    }

    private boolean checkIfCanBeAddedToRow(SudokuElement element) {
        SudokuRow row = board.getRows().get(element.getX());
        for (SudokuElement sudokuElement : row.getRowElements()) {
            if (sudokuElement.getValue() == element.getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfCanBeAddedToColumn(SudokuElement element) {
        SudokuColumn column = board.getColumns().get(element.getY());
        for (SudokuElement sudokuElement : column.getColumnElements()) {
            if (sudokuElement.getValue() == element.getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfCanBeAddedToBlock(SudokuElement element) {
        for (SudokuRow row : board.getRows()) {
            for (SudokuElement sudokuElement : row.getRowElements()) {
                if (sudokuElement.equals(element)) {
                    element.setBlock(sudokuElement.getBlock());
                }
            }
        }
        for (SudokuRow row : board.getRows()) {
            for (SudokuElement sudokuElement : row.getRowElements()) {
                if (sudokuElement.getBlock() == element.getBlock() && sudokuElement.getValue() == element.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
