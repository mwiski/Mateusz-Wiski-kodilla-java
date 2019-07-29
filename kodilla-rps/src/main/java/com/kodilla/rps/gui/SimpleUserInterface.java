package com.kodilla.rps.gui;

import com.kodilla.rps.gameDefinition.GameDefinition;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.round.AfterRound;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.statistics.RoundResult;
import com.kodilla.rps.statistics.Statistics;

import java.util.Scanner;

public class SimpleUserInterface implements UserInterface {

    private final static Scanner scanner = new Scanner(System.in);

    public void printIntro() {
        System.out.println("Welcome to the Rock-Paper-Scissors game.");
    }

    public  GameDefinition nameAndRoundsToWinQuestion() {
        System.out.println("Please, enter your name:");
        String name = scanner.nextLine();

        if (name.equals("")) {
            System.out.println("User name must have at least one letter");
            nameAndRoundsToWinQuestion();
        }

        System.out.println("Please, enter number of rounds to win one game:");
        int rounds = scanner.nextInt();
        scanner.nextLine();

        return new GameDefinition(name, rounds);
    }

    public  void printInstruction() {
        System.out.println("Enter 1 to choose ROCK. \n" +
                "Enter 2 to choose PAPER. \n" +
                "Enter 3 to choose SCISSORS. \n" +
                "Enter x to EXIT GAME. \n" +
                "Enter n to START NEW GAME.");
    }

    public void printRoundResult(String playerName,
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

    public  String scanPlayerMove() {
        return scanner.nextLine();
    }

    public  void printWinner(String name, int playerWins, int computerWins) {
        System.out.println(name + " wins! \n" +
                name + " game wins: " + playerWins +
                "\nComputer game wins: " + computerWins);
    }

    public  void printAfterGameInfo(AfterRound afterRound, Round round, Statistics statistics) {
        System.out.println("What do you want to do next? \n" +
                "Enter x to END GAME. \n" +
                "Enter n to START NEW GAME.");
        String choice = scanner.nextLine();

        if (choice.equals("x")) {
            afterRound.react(this, RoundResult.EXIT, round, statistics);
        } else if (choice.equals("n")) {
            printIntro();
            GameDefinition definition = nameAndRoundsToWinQuestion();
            afterRound.react(this, round.play(afterRound), new Round(statistics, definition, this), statistics);
        } else {
            System.out.println("You chose wrong character");
            printAfterGameInfo(afterRound, round, statistics);
        }
    }

    public  String exitGameInfo() {
        System.out.println("Are you sure you want to exit game? \n" +
                "Enter \"y\" to yes or other text to no.");
        return scanner.nextLine();
    }

    public  String resetGameInfo() {
        System.out.println("Are you sure you want to exit current game and start new one? \n" +
                "Enter \"y\" to yes or other text to no.");
        return scanner.nextLine();
    }
}
