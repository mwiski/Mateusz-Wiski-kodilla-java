package com.kodilla.sudoku.board;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SudokuColumn)) return false;
        SudokuColumn column = (SudokuColumn) o;
        return number == column.number &&
                columnElements.equals(column.columnElements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnElements, number);
    }
}
