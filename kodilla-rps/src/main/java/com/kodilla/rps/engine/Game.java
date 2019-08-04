package com.kodilla.rps.engine;

import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.GameResult;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.statistics.Statistics;
import static com.kodilla.rps.model.RoundResult.*;

public class Game {

    private final UserInterface userInterface;
    private final Statistics statistics;
    private GameDefinition definition;

    public Game(UserInterface userInterface) {
        this.userInterface = userInterface;
        this.statistics = new Statistics();
    }

    GameResult start() {
        userInterface.printIntro();
        definition = getGameDefinition();
        RoundResult result = RoundResult.DRAW;
        while (shouldPlay(definition, result)) {
            result = new Round(statistics, userInterface, definition).play();
        }

        if (result == RESET) {
            return GameResult.RESET;
        } else if (result == EXIT) {
            return GameResult.EXIT;
        }
        return userInterface.afterGameInfo(definition, statistics);
    }

    private boolean shouldPlay(GameDefinition definition, RoundResult result) {
        if (result == EXIT) {
            if (userInterface.confirmExit()){
                return false;
            }
        }
        if (result == RESET) {
            if (userInterface.confirmReset()){
                return false;
            }
        }
        return statistics.isGameOn(definition.getRoundsToWin());
    }

    private GameDefinition getGameDefinition() {
        String userName = userInterface.nameQuestion();
        int roundCount = userInterface.roundsToWinGameQuestion();
        return new GameDefinition(userName, roundCount);
    }

    String getUsername() {
        return definition.getPlayerName();
    }
}
