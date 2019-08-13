package com.kodilla.sudoku.board;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SudokuRow)) return false;
        SudokuRow row = (SudokuRow) o;
        return number == row.number &&
                rowElements.equals(row.rowElements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowElements, number);
    }
}
