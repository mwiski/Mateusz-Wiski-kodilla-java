package com.kodilla.sudoku.board;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SudokuBoard {

    private List<SudokuRow> rows;
    private List<SudokuColumn> columns;

    public void addPlayerMove(SudokuElement element) {
        rows.get(element.getX()).getElement(element.getY()).setValue(element.getValue());
    }

    public static class Builder {
        private List<SudokuRow> rows = new ArrayList<>();
        private List<SudokuColumn> columns = new ArrayList<>();

        public Builder board(int boardSize, int blockSize) {
            for (int i = 0; i < boardSize; i++) {
                rows.add(new SudokuRow(i + 1));
                for (int k = 0; k < boardSize; k++) {
                    rows.get(i).addRowElement(new SudokuElement(i, k));
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
            int blockNumber = -1;
            for (int i = 0; i < columns.size(); i += blockSize) {
                for (int k = 0; k < rows.size(); k += blockSize) {
                    blockNumber++;
                    for (int row = i; row < result + i; row++) {
                        for (int column = k; column < result + k; column++) {
                            rows.get(row).getElement(column).setBlock(blockNumber);
                        }
                    }
                }
            }
        }

        public SudokuBoard build() {
            return new SudokuBoard(rows, columns);
        }
    }

    private SudokuBoard(List<SudokuRow> rows, List<SudokuColumn> columns) {
        this.rows = rows;
        this.columns = columns;
    }
}
