package com.kodilla.rps.gui;

import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.GameResult;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.statistics.Statistics;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SimpleUserInterface implements UserInterface {

    private final static Scanner scanner = new Scanner(System.in);
    private final static List<String> VALID_MOVES = Arrays.asList("1", "2", "3", "x", "n");

    public void printIntro() {
        System.out.println("Welcome to the Rock-Paper-Scissors engine.");
    }

    public String nameQuestion() {
        System.out.println("Please, enter your name:");
        String name = scanner.nextLine();

        if (name.equals("")) {
            System.out.println("User name must have at least one letter");
            name = nameQuestion();
        }
        return name;
    }

    public int roundsToWinGameQuestion() {
        System.out.println("Please, enter number of rounds to win one engine:");
        int rounds = scanner.nextInt();
        scanner.nextLine();
        return rounds;
    }

    public void showInstruction() {
        System.out.println("Enter 1 - ROCK." +
                " Enter 2 - PAPER. " +
                " Enter 3 - SCISSORS. " +
                " Enter x to EXIT GAME. " +
                " Enter n to START NEW GAME.");
    }

    public void showRoundResult(GameDefinition definition,
                                Move playerMove,
                                Move computerMove,
                                RoundResult result,
                                Statistics statistics) {

        System.out.println(definition.getPlayerName() + " chose: " + playerMove +
                ", Computer chose: " + computerMove +
                ", Round result is: " + result +
                ". \n" + definition.getPlayerName() + " rounds won: " + statistics.getPlayerRoundsWin() +
                ". Computer rounds won: " + statistics.getComputerRoundsLost() + "\n");
    }

    public void printRoundNumber(int roundNumber) {
        System.out.println("Round no: " + roundNumber);
    }

    private String scanPlayerMove() {
        String playerInput = scanner.nextLine();

        if (VALID_MOVES.contains(playerInput)) {
            return playerInput;
        }
        printWrongCharacter();
        return scanPlayerMove();
    }

    public Move getPlayerMove() {
        String playerInput = scanPlayerMove();

        switch (playerInput) {
            case "1": {
                return Move.ROCK;
            }
            case "2": {
                return Move.PAPER;
            }
            case "3": {
                return Move.SCISSORS;
            }
            case "x": {
                return Move.EXIT;
            }
            case "n": {
                return Move.RESET;
            }
            default: {
                throw new IllegalArgumentException("Wrong player Move");
            }
        }
    }

    public void showWinner(GameDefinition definition, Statistics statistics) {
        if (statistics.getPlayerRoundsWin() == definition.getRoundsToWin()) {
            System.out.println(definition.getPlayerName() + " wins!" + "\n");
        } else if (statistics.getComputerRoundsLost() == definition.getRoundsToWin()) {
            System.out.println("Computer wins!" + "\n");
        }
    }

    public GameResult afterGameInfo(GameDefinition definition, Statistics statistics) {
        showWinner(definition, statistics);

        System.out.println("What do you want to do next? \n" +
            "Enter x to EXIT GAME. \n" +
            "Enter n to START NEW GAME.");

        String choice = scanner.nextLine();
        while (!choice.equals("x") && !choice.equals("n")) {
            printWrongCharacter();
            choice = scanner.nextLine();
        }
        if (choice.equals("x")) {
            return GameResult.EXIT;
        } else {
            return GameResult.RESET;
        }
    }

    public boolean confirmExit() {
        System.out.println("Are you sure you want to exit engine? \n" +
                "Enter \"y\" to yes or \"n\" to no.");
        String answer = scanner.nextLine();

        if (answer.equals("y")) {
            return true;
        } else if (!answer.equals("n")) {
            printWrongCharacter();
            return confirmExit();
        }
        return false;
    }

    public boolean confirmOnceAgain() {
        System.out.println("You are about to leave the engine? Are you sure? \n" +
                "Enter \"y\" to yes or \"n\" to no.");
        String answer = scanner.nextLine();

        if (answer.equals("y")) {
            return true;
        } else if (!answer.equals("n")) {
            printWrongCharacter();
            return confirmOnceAgain();
        }
        return false;
    }

    public boolean confirmReset() {
        System.out.println("Are you sure you want to exit current engine and start new one? \n" +
                "Enter \"y\" to yes or \"n\" to no.");
        String answer = scanner.nextLine();

        if (answer.equals("y")) {
            return true;
        } else if (!answer.equals("n")) {
            printWrongCharacter();
            return confirmReset();
        }
        return false;
    }

    public void printWrongCharacter() {
        System.out.println("You chose wrong character. Try again:");
    }

    public void thankYou(String username) {
        System.out.println("Thank you for playing " + username + "!");
    }
}
