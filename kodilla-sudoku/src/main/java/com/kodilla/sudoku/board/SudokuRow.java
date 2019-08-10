package com.kodilla.sudoku.board;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SudokuRow {

    private List<SudokuElement> rowElements;
    private final int number;

    public SudokuRow(final int number) {
        this.rowElements = new ArrayList<>();
        this.number = number;
    }

    public void addRowElement(SudokuElement sudokuElement) {
        rowElements.add(sudokuElement);
    }

    public SudokuElement getElement(int n) {
        return rowElements.get(n);
    }
}
