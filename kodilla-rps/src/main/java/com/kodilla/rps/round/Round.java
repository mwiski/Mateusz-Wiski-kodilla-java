package com.kodilla.rps.round;

import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.statistics.Statistics;
import com.kodilla.rps.strategy.ComputerStrategy;
import com.kodilla.rps.strategy.PlayerStrategy;

public class Round {

    private final RoundChecker checker;
    private ComputerStrategy computerStrategy;
    private PlayerStrategy playerStrategy;
    private Statistics statistics;
    private GameDefinition definition;
    private RoundResult result;
    private UserInterface gui;

    public Round(Statistics statistics, GameDefinition definition, UserInterface gui) {
        this.checker = new RoundChecker();
        this.computerStrategy = new ComputerStrategy();
        this.playerStrategy = new PlayerStrategy();
        this.statistics = statistics;
        this.definition = definition;
        this.gui = gui;
    }

    public boolean play() {
        gui.showInstruction();
        playerStrategy.scanMove(gui);
        result = checker.checkIfResetOrExit(gui, playerStrategy.getPlayerInput());

        checkMoves();
        checkGameWinner();

        if (checkGameWinner()) {

            return true;
        }
        return false;
    }

    private void checkMoves() {
        if (result == null) {
            result = checker.compare(playerStrategy.getMove(), computerStrategy.getMove());
            statistics.addResult(result);
            gui.showRoundResult(definition.getPlayerName(),
                    playerStrategy.getPlayerMove(),
                    computerStrategy.getComputerMove(),
                    result,
                    statistics.getPlayerRoundResult(),
                    statistics.getComputerRoundResult());
        }
    }

    private boolean checkGameWinner() {
        if (statistics.checkGameResult(definition.getRoundsToWin())) {
            gui.showWinner(definition, statistics.getWins(), statistics.getLosts());
            statistics.resetRoundScore();
            return true;
        }
        return false;
    }
}
