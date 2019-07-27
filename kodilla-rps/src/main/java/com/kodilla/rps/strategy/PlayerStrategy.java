package com.kodilla.rps.strategy;

import com.kodilla.rps.gameDefinition.GameDefinition;
import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.statistics.RoundResult;
import com.kodilla.rps.statistics.Statistics;

public class PlayerStrategy {

    private Move playerMove;

    public Move getMove(String move) {
        switch (UserInterface.scanPlayerMove()) {
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

    public String playerMove() {
        String move = UserInterface.scanPlayerMove();
        if (move.equals("1") || move.equals("2") || move.equals("3") || move.equals("n") || move.equals("x")) {
            return move;
        }
        return "You chose wrong character. Try again:" + playerMove();
    }

    public GameDefinition init() {
        UserInterface.printIntro();
        return UserInterface.nameAndRoundsToWinQuestion();
    }

    public Move getPlayerMove() {
        return playerMove;
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
