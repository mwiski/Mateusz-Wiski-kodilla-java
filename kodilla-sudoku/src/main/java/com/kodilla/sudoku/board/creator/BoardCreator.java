package com.kodilla.sudoku.board.creator;

import com.kodilla.sudoku.board.*;

public class BoardCreator {
    
    private SudokuBoard board;

    public BoardCreator(SudokuBoard board) {
        this.board = board;
    }

    public void createBoard(int boardSize, int blockSize) {
        for (int i = 0; i < boardSize; i++) {
            board.getRows().add(new SudokuRow(i + 1));
            for (int k = 0; k < boardSize; k++) {
                board.getRows().get(i).addRowElement(new SudokuElement(k + 1, i + 1));
            }
        }
        defineColumns();
        defineBlocks(blockSize);
    }

    private void defineColumns() {
        for (int i = 0; i < board.getRows().size(); i++) {
            board.getColumns().add(new SudokuColumn(i + 1));
            for (SudokuRow row : board.getRows()) {
                board.getColumns().get(i).addColumnElement(row.getElement(i));
            }
        }
    }

    private void defineBlocks(int blockSize) {
        int result = board.getRows().size() / blockSize;
        for (int i = 0; i < board.getRows().size(); i += blockSize) {
            for (int k = 0; k < board.getRows().size(); k += blockSize) {
                SudokuBlock block = new SudokuBlock();
                board.getBlocks().add(block);
                for (int j = 0; j < result; j++) {
                    for (int l = 0; l < result; l++) {
                        block.addBlockElement(board.getRows().get(j).getElement(l));
                    }
                }
            }
        }
    }
}
