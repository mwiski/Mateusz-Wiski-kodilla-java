package com.kodilla.rps.gui;

import com.kodilla.rps.gameDefinition.GameDefinition;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.statistics.RoundResult;
import com.kodilla.rps.statistics.Statistics;
import com.kodilla.rps.strategy.PlayerStrategy;

import java.util.Scanner;

public class UserInterface {

    private final static Scanner scanner = new Scanner(System.in);

    public static void printIntro() {
        System.out.println("Welcome to the Rock-Paper-Scissors game.");
    }

    public static GameDefinition nameAndRoundsToWinQuestion() {
        System.out.println("Please, enter your name:");
        String name = scanner.nextLine();

        if (name.equals("")) {
            System.out.println("User name must have at least one letter");
            nameAndRoundsToWinQuestion();
        }

        System.out.println("Please, enter number of rounds to win one game:");
        int rounds = scanner.nextInt();

        return new GameDefinition(name, rounds);
    }

    public static void printInstruction() {
        System.out.println("Enter 1 to choose ROCK. \n" +
                "Enter 2 to choose PAPER. \n" +
                "Enter 3 to choose SCISSORS. \n" +
                "Enter x to EXIT GAME. \n" +
                "Enter n to START NEW GAME.");
    }

    public static void printRoundResult(String playerName,
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

    public static String scanPlayerMove() {
        return scanner.nextLine();
    }

    public static void printWinner(String name, int playerWins, int computerWins) {
        System.out.println(name + " wins! \n" +
                name + " game wins: " + playerWins +
                "\nComputer game wins: " + computerWins);
    }

    public static void printAfterGameInfo(PlayerStrategy playerStrategy, Round round, Statistics statistics) {
        System.out.println("What do you want to do next? \n" +
                "Enter x to END GAME. \n" +
                "Enter n to START NEW GAME.");
        String choice = scanner.nextLine();

        if (choice.equals("x")) {
            playerStrategy.react(RoundResult.EXIT, round, statistics);
        } else if (choice.equals("n")) {
            playerStrategy.react(RoundResult.END, round, statistics);
        } else {
            System.out.println("You chose wrong character");
            printAfterGameInfo(playerStrategy, round, statistics);
        }
    }

    public static String exitGameInfo() {
        System.out.println("Are you sure you want to exit game? \n" +
                "Enter \"y\" to yes or other text to no.");
        return scanner.nextLine();
    }

    public static String resetGameInfo() {
        System.out.println("Are you sure you want to exit current game and start new one? \n" +
                "Enter \"y\" to yes or other text to no.");
        return scanner.nextLine();
    }
}
