package com.kodilla.rps.gui;

import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.GameResult;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.round.AfterRound;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.statistics.Statistics;

import java.util.Scanner;

public class SimpleUserInterface implements UserInterface {

    private final static Scanner scanner = new Scanner(System.in);

    public SimpleUserInterface() {
        printIntro();
    }

    public void printIntro() {
        System.out.println("Welcome to the Rock-Paper-Scissors game.");
    }

    public String nameQuestion() {
        System.out.println("Please, enter your name:");
        String name = scanner.nextLine();

        if (name.equals("")) {
            System.out.println("User name must have at least one letter");
            nameQuestion();
        }
        return name;
    }

    public int roundsQuestion() {
        System.out.println("Please, enter number of rounds to win one game:");
        int rounds = scanner.nextInt();
        scanner.nextLine();
        return rounds;
    }

    public void showInstruction() {
        System.out.println("Enter 1 to choose ROCK. \n" +
                "Enter 2 to choose PAPER. \n" +
                "Enter 3 to choose SCISSORS. \n" +
                "Enter x to EXIT GAME. \n" +
                "Enter n to START NEW GAME.");
    }

    public void showRoundResult(String playerName,
                                Move playerMove,
                                Move computerMove,
                                RoundResult result,
                                int playerRoundResult,
                                int computerRoundResult) {

        System.out.println(playerName + " chose: " + playerMove +
                "\nComputer chose: " + computerMove +
                "\nRound result: " + result +
                "\n" + playerName + " rounds won: " + playerRoundResult +
                "\nComputer rounds won: " + computerRoundResult + "\n");
    }

    public String scanPlayerMove() {
        String playerInput = scanner.nextLine();

        if (playerInput.equals("1") || playerInput.equals("2") || playerInput.equals("3") || playerInput.equals("n") || playerInput.equals("x")) {
            return playerInput;
        }
        printWrongCharacter();
        return scanPlayerMove();
    }

    public void showWinner(GameDefinition definition, int playerWins, int computerWins) {
        if (playerWins == definition.getRoundsToWin()) {
            System.out.println(definition.getPlayerName() + " wins! \n" +
                    definition.getPlayerName() + " game wins: " + playerWins +
                    "\nComputer game wins: " + computerWins);
        } else if (computerWins == definition.getRoundsToWin()) {
            System.out.println("Computer wins! \n" +
                    definition.getPlayerName() + " game wins: " + playerWins +
                    "\nComputer game wins: " + computerWins);
        }
    }

    public GameResult afterGameInfo(AfterRound afterRound, Round round, Statistics statistics) {
        System.out.println("What do you want to do next? \n" +
                "Enter x to RESET GAME. \n" +
                "Enter n to START NEW GAME.");
        String choice = scanner.nextLine();

        if (choice.equals("x")) {
            return GameResult.EXIT;
        } else if (choice.equals("n")) {
            return GameResult.RESET;
        } else {
            System.out.println("You chose wrong character");
            return afterGameInfo(afterRound, round, statistics);
        }
    }

    public RoundResult exitGame() {
        System.out.println("Are you sure you want to exit game? \n" +
                "Enter \"y\" to yes or other text to no.");
        if (scanner.nextLine().equals("y")) {
            return RoundResult.EXIT;
        }
        return RoundResult.CONTINUE;
    }

    public RoundResult resetGame() {
        System.out.println("Are you sure you want to exit current game and start new one? \n" +
                "Enter \"y\" to yes or other text to no.");
        if (scanner.nextLine().equals("y")) {
            return RoundResult.RESET;
        }
        return RoundResult.CONTINUE;
    }

    public void printWrongCharacter() {
        System.out.println("You chose wrong character. Try again:");
    }
}
