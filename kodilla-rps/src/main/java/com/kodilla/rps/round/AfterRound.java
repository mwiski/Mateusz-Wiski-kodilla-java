package com.kodilla.rps.round;

import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.statistics.Statistics;

public class AfterRound {

    public boolean checkRoundResult(RoundResult result, Round round, Statistics statistics, UserInterface gui) {
        switch (result) {
            case WIN:
            case LOSE:
            case DRAW:
            case CONTINUE: {
                checkRoundResult(round.play(), round, statistics, gui);
                return false;
            }
            case RESET: {
                statistics.resetRoundScore();
                GameDefinition definition = new GameDefinition(gui.nameQuestion(), gui.roundsQuestion());
                Round newRound = new Round(statistics, definition, gui);
                checkRoundResult(newRound.play(), newRound, statistics, gui);
                return true;
            }
            case EXIT: {
                System.exit(0);
            }
            default: {
                return false;
            }
        }
    }
}
