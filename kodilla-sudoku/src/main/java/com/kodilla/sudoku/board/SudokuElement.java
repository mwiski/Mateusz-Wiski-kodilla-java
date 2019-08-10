package com.kodilla.sudoku.board;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SudokuElement {

    public static int EMPTY = 0;
    private int x;
    private int y;
    private int value = EMPTY;

    public SudokuElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
