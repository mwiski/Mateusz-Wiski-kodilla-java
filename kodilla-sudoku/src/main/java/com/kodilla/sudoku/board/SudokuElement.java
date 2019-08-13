package com.kodilla.sudoku.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class SudokuElement {

    public static int EMPTY = 0;
    private int x;
    private int y;
    private int value = EMPTY;
    private int block;

    public SudokuElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SudokuElement)) return false;
        SudokuElement element = (SudokuElement) o;
        return x == element.x &&
                y == element.y &&
                block == element.block;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, block);
    }
}
