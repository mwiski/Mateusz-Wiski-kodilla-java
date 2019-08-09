package com.kodilla.sudoku.board;

import com.kodilla.sudoku.board.creator.BoardCreator;
import com.kodilla.sudoku.board.validator.SudokuValidator;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SudokuBoard {

    private List<SudokuRow> rows;
    private List<SudokuColumn> columns;
    private List<SudokuBlock> blocks;
    private BoardCreator creator;
    private SudokuValidator validator;

    public SudokuBoard(int boardSize, int blockSize) {
        this.rows = new ArrayList<>();
        this.columns = new ArrayList<>();
        this.blocks = new ArrayList<>();
        this.creator = new BoardCreator(this);
        this.validator = new SudokuValidator(this);
        creator.createBoard(boardSize, blockSize);
    }

    public boolean addPlayerMove(SudokuElement element) {
        if (validator.validate(element)) {
            rows.get(element.getX()).getElement(element.getY()).setValue(element.getValue());
            return true;
        }
        return false;
    }
}
