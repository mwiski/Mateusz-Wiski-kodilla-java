package com.kodilla.rps.round;

import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.statistics.Statistics;
import com.kodilla.rps.strategy.ComputerStrategy;
import com.kodilla.rps.strategy.PlayerStrategy;

public class Round {

    private final int number;
    private final RoundChecker checker;
    private ComputerStrategy computerStrategy;
    private PlayerStrategy playerStrategy;
    private Statistics statistics;
    private UserInterface gui;
    private GameDefinition definition;

    public Round(Statistics statistics, UserInterface gui, GameDefinition definition) {
        this.number = statistics.getRoundNumber() + 1;
        this.computerStrategy = new ComputerStrategy();
        this.gui = gui;
        this.playerStrategy = new PlayerStrategy(gui);
        this.statistics = statistics;
        this.definition = definition;
        this.checker = new RoundChecker();
    }

    public RoundResult play() {
        gui.printRoundNumber(number);
        gui.showInstruction();
        RoundResult result = checker.compareMoves(playerStrategy.getMove(), computerStrategy.getMove());
        if (!result.equals(RoundResult.RESET) && !result.equals(RoundResult.EXIT)) {
            statistics.updateStatistics(result);
            gui.showRoundResult(definition, playerStrategy.getPlayerMove(), computerStrategy.getComputerMove(), result, statistics);
        }
        return result;
    }
}
