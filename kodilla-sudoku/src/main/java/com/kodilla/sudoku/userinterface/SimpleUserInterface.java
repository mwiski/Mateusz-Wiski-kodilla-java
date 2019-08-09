package com.kodilla.sudoku.userinterface;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuElement;
import java.util.Scanner;

public class SimpleUserInterface implements UserInterface {

    private final static Scanner scanner = new Scanner(System.in);
    private final static SudokuElement RESOLVE_SUDOKU = new SudokuElement(-1, -1);

    public SudokuElement getPlayerMove() {
        String playerInput = scanner.nextLine();
        if (!validate(playerInput)) {
            wrongInput();
            getPlayerMove();
        } else if (playerInput.equals("sudoku")){
            return RESOLVE_SUDOKU;
        }
        return new SudokuElement();
    }


    public void showBoard(SudokuBoard board) {

    }

    public boolean validate(String playerMove) {
        //Implement method body
        return false;
    }

    public void wrongInput() {
        System.out.println("You entered wrong input. Please, try again:");
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
