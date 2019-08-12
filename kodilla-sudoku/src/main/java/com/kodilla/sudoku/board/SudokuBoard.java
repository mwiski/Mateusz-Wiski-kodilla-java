package com.kodilla.sudoku.board;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SudokuBoard {

    private List<SudokuRow> rows;
    private List<SudokuColumn> columns;
    private List<SudokuBlock> blocks;

    public void addPlayerMove(SudokuElement element) {
        rows.get(element.getX()).getElement(element.getY()).setValue(element.getValue());
    }

    public static class Builder {
        private List<SudokuRow> rows = new ArrayList<>();
        private List<SudokuColumn> columns = new ArrayList<>();
        private List<SudokuBlock> blocks = new ArrayList<>();

        public Builder board(int boardSize, int blockSize) {
            for (int i = 0; i < boardSize; i++) {
                rows.add(new SudokuRow(i + 1));
                for (int k = 0; k < boardSize; k++) {
                    rows.get(i).addRowElement(new SudokuElement(k, i));
                }
            }
            defineColumns();
            defineBlocks(blockSize);
            return this;
        }

        private void defineColumns() {
            for (int i = 0; i < rows.size(); i++) {
                columns.add(new SudokuColumn(i + 1));
                for (SudokuRow row : rows) {
                    columns.get(i).addColumnElement(row.getElement(i));
                }
            }
        }

        private void defineBlocks(int blockSize) {
            int result = rows.size() / blockSize;
            for (int i = 0; i < rows.size(); i += blockSize) {
                for (int k = 0; k < rows.size(); k += blockSize) {
                    SudokuBlock block = new SudokuBlock();
                    blocks.add(block);
                    for (int j = 0; j < result; j++) {
                        for (int l = 0; l < result; l++) {
                            block.addBlockElement(rows.get(j).getElement(l));
                        }
                    }
                }
            }
        }

        public SudokuBoard build() {
            return new SudokuBoard(rows, columns, blocks);
        }
    }

    private SudokuBoard(List<SudokuRow> rows, List<SudokuColumn> columns, List<SudokuBlock> blocks) {
        this.rows = rows;
        this.columns = columns;
        this.blocks = blocks;
    }
}
