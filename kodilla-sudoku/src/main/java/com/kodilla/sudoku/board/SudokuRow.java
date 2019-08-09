package com.kodilla.sudoku.board;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SudokuRow {

    private List<SudokuElement> rowElements;

    public SudokuRow() {
        this.rowElements = new ArrayList<>();
    }

    public void addRowElement(SudokuElement sudokuElement) {
        rowElements.add(sudokuElement);
    }

    public SudokuElement getElement(int n) {
        return rowElements.get(n);
    }
}
