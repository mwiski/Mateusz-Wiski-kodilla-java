package com.kodilla.sudoku.userinterface;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuColumn;
import com.kodilla.sudoku.board.SudokuElement;
import com.kodilla.sudoku.board.SudokuRow;
import java.util.Scanner;

public class SimpleUserInterface implements UserInterface {

    private final static Scanner scanner = new Scanner(System.in);
    private static final int BLOCK_SIZE = 3;

    public void showIntro() {
        System.out.println("Welcome to Sudoku application.");
        showInstruction();
        System.out.println();
    }

    public void showInstruction() {
        System.out.println("Enter number of row, column and then value. \n" +
                "I.e. enter \"1,2,3\" to put value \"3\" to element in 1. row and 2. column.\n" +
                "If you enter word \"SUDOKU\", program will resolve Sudoku.\n" +
                "Possible values to enter are: 1-9.");
    }
    
    public String getPlayerMove() {
        System.out.println("Enter your move: ");
        String playerMove = scanner.nextLine();
        if (validate(playerMove)) {
            return playerMove;
        }
        wrongInput();
        return getPlayerMove();
    }

    public SudokuElement getSudokuElement(String playerMove) {
        int row = Integer.parseInt(playerMove.substring(0, 1));
        int column = Integer.parseInt(playerMove.substring(2, 3));
        int value = Integer.parseInt(playerMove.substring(4, 5));
        SudokuElement element = new SudokuElement(row - 1, column - 1);
        element.setValue(value);
        return element;
    }

    public void showBoard(SudokuBoard board) {
        System.out.print("  ");
        for (SudokuColumn column : board.getColumns()) {
            if (column.getNumber() % BLOCK_SIZE == 1) {
                System.out.print("   ");
                System.out.printf("%d  ", column.getNumber());
            } else {
                System.out.printf("%d  ", column.getNumber());
            }
        }
        System.out.println();
        System.out.println("    ---------------------------------");
        for (SudokuRow row : board.getRows()) {
            if (row.getNumber() != 1 && row.getNumber() % BLOCK_SIZE == 1) {
                System.out.println();
                System.out.printf("%-4d", row.getNumber());
            } else {
                System.out.printf("%-4d", row.getNumber());
            }

            for (int i = 0; i < row.getRowElements().size(); i++) {
                if (i != 0 && i % BLOCK_SIZE == 0) {
                    System.out.print("   ");
                    System.out.printf("|%d|", row.getElement(i).getValue());
                } else {
                    System.out.printf("|%d|", row.getElement(i).getValue());
                }
            }
            System.out.println();
        }
        System.out.println("    ---------------------------------");

    }

    private boolean validate(String playerMove) {
        return (playerMove.matches("\\d" + "," + "\\d" + "," + "\\d") || playerMove.equals("SUDOKU"))
                && !playerMove.matches("0,0,0");
    }

    private void wrongInput() {
        System.out.println("You entered wrong input. Please, try again:");
    }

    public void wrongMove() {
        System.out.println("Wrong move. This element already has a value or this value is in its row, column or block");
    }

    public boolean playAgain() {
        System.out.println("Would you like to play again?" +
                "\nEnter \"y\" to yes or \"n\" to no.");
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            return true;
        } else if (answer.equals("n")) {
            return askAgain();
        } else {
            wrongInput();
            return playAgain();
        }
    }

    public boolean askAgain() {
        System.out.println("You are about to exit game. Are you sure?" +
                "\nEnter \"y\" to yes or \"n\" to no.");
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            return false;
        } else if (answer.equals("n")) {
            return true;
        } else {
            wrongInput();
            return askAgain();
        }
    }

    public void thankYou() {
        System.out.println("Thank you for playing!");
    }
}
