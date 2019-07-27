package com.kodilla.rps.strategy;

import com.kodilla.rps.gameDefinition.GameDefinition;
import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.statistics.RoundResult;
import com.kodilla.rps.statistics.Statistics;

public class PlayerStrategy {

    private Move playerMove;
    private String playerInput;

    public String scanMove() {
        return playerInput = UserInterface.scanPlayerMove();
    }
    
    public Move getMove(String move) {
        switch (move) {
            case "1": {
                return playerMove = Move.ROCK;
            }
            case "2": {
                return playerMove = Move.PAPER;
            }
            case "3": {
                return playerMove = Move.SCISSORS;
            }
            default: {
                return getMove(move);
            }
        }
    }
    
    public boolean validate() {
        return playerInput.equals("1") || playerInput.equals("2") || playerInput.equals("3") || playerInput.equals("n") || playerInput.equals("x");
    }

    public GameDefinition init() {
        UserInterface.printIntro();
        return UserInterface.nameAndRoundsToWinQuestion();
    }

    public Move getPlayerMove() {
        return playerMove;
    }

    public String getPlayerInput() {
        return playerInput;
    }

    public void react(RoundResult result, Round round, Statistics statistics) {
        switch (result) {
            case WIN: {
                react(round.play(this), round, statistics);
            }
            case LOSE: {
                react(round.play(this), round, statistics);
            }
            case DRAW: {
                react(round.play(this), round, statistics);
            }
            case END: {
                if (UserInterface.resetGameInfo().equals("y")) {
                    statistics.resetRoundScore();
                    GameDefinition definition = init();
                    react(round.play(this), new Round(statistics, definition), statistics);
                }
            }
            case EXIT: {
                if (UserInterface.exitGameInfo().equals("y")) {
                    System.exit(0);
                }
                react(round.play(this), round, statistics);
            }
        }
    }
}
