package com.kodilla.sudoku.board;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public class SudokuElement {

    public static int EMPTY = 0;
    private List<Integer> possibleValues;
    private int x;
    private int y;
    private int value = EMPTY;

    public SudokuElement(int x, int y) {
        this.possibleValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        this.x = x;
        this.y = y;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void removeValue(int n) {
        possibleValues.remove(n);
    }
}
