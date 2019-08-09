package com.kodilla.sudoku.board;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SudokuBlock {

    private List<SudokuElement> blockElements;

    public SudokuBlock() {
        this.blockElements = new ArrayList<>();
    }

    public void addBlockElement(SudokuElement sudokuElement) {
        blockElements.add(sudokuElement);
    }
}