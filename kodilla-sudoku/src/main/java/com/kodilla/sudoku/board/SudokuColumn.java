package com.kodilla.sudoku.board;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SudokuColumn {

    private List<SudokuElement> columnElements;

    public SudokuColumn() {
        this.columnElements = new ArrayList<>();
    }

    public void addColumnElement(SudokuElement sudokuElement) {
        columnElements.add(sudokuElement);
    }
}
