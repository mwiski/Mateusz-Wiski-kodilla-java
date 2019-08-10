package com.kodilla.sudoku.board;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SudokuColumn {

    private List<SudokuElement> columnElements;
    private final int number;

    public SudokuColumn(final int number) {
        this.columnElements = new ArrayList<>();
        this.number = number;
    }

    public void addColumnElement(SudokuElement sudokuElement) {
        columnElements.add(sudokuElement);
    }
}
