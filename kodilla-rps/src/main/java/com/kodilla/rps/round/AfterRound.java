package com.kodilla.rps.round;

import com.kodilla.rps.gameDefinition.GameDefinition;
import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.statistics.RoundResult;
import com.kodilla.rps.statistics.Statistics;

public class AfterRound {

    public void react(UserInterface gui, RoundResult result, Round round, Statistics statistics) {
        switch (result) {
            case WIN: {
                react(gui, round.play(this), round, statistics);
            }
            case LOSE: {
                react(gui, round.play(this), round, statistics);
            }
            case DRAW: {
                react(gui, round.play(this), round, statistics);
            }
            case END: {
                if (gui.resetGameInfo().equals("y")) {
                    statistics.resetRoundScore();
                    gui.printIntro();
                    GameDefinition definition = gui.nameAndRoundsToWinQuestion();
                    react(gui, round.play(this), new Round(statistics, definition, gui), statistics);
                }
                react(gui, round.play(this), round, statistics);
            }
            case EXIT: {
                if (gui.exitGameInfo().equals("y")) {
                    System.exit(0);
                }
                react(gui, round.play(this), round, statistics);
            }
        }
    }
}
