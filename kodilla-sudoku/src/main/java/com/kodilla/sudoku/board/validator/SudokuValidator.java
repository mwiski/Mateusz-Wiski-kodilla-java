package com.kodilla.sudoku.board.validator;

import com.kodilla.sudoku.board.*;

public class SudokuValidator {
    
    private SudokuBoard board;

    public SudokuValidator(SudokuBoard board) {
        this.board = board;
    }

    public boolean validate(SudokuElement element) {

        if (!validateElement(element)) {
            return false;
        } else if (!validateRow(element)) {
            return false;
        } else if (!validateColumn(element)) {
            return false;
        } else return validateBlock(element);
    }

    private boolean validateElement(SudokuElement element) {
        return board.getRows().get(element.getX()).getElement(element.getY()).getValue() == SudokuElement.EMPTY;
    }

    private boolean validateRow(SudokuElement element) {
        SudokuRow row = board.getRows().get(element.getX());
        for (SudokuElement sudokuElement : row.getRowElements()) {
            if (sudokuElement.getValue() == element.getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean validateColumn(SudokuElement element) {
        SudokuColumn column = board.getColumns().get(element.getY());
        for (SudokuElement sudokuElement : column.getColumnElements()) {
            if (sudokuElement.getValue() == element.getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean validateBlock(SudokuElement element) {
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
