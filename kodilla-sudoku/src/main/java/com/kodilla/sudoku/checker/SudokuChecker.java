package com.kodilla.sudoku.checker;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuColumn;
import com.kodilla.sudoku.board.SudokuElement;
import com.kodilla.sudoku.board.SudokuRow;

public class SudokuChecker {

    private SudokuBoard board;

    public SudokuChecker(SudokuBoard board) {
        this.board = board;
    }

    public boolean canBeAddedToBoard(SudokuElement element) {
        if (!isElementEmpty(element)) {
            return false;
        }
        if (!canBeAddedToRow(element)) {
            return false;
        } else if (!canBeAddedToColumn(element)) {
            return false;
        } else return canBeAddedToBlock(element);
    }

    private boolean isElementEmpty(SudokuElement element) {
        return board.getRows().get(element.getX()).getElement(element.getY()).getValue() == SudokuElement.EMPTY;
    }

    private boolean canBeAddedToRow(SudokuElement element) {
        SudokuRow row = board.getRows().get(element.getX());
        for (SudokuElement sudokuElement : row.getRowElements()) {
            if (sudokuElement.getValue() == element.getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean canBeAddedToColumn(SudokuElement element) {
        SudokuColumn column = board.getColumns().get(element.getY());
        for (SudokuElement sudokuElement : column.getColumnElements()) {
            if (sudokuElement.getValue() == element.getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean canBeAddedToBlock(SudokuElement element) {
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
