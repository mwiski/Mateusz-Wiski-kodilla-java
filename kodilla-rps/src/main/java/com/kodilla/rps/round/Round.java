package com.kodilla.rps.round;

import com.kodilla.rps.gameDefinition.GameDefinition;
import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.statistics.RoundResult;
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

    public RoundResult play(AfterRound afterRound) {
        gui.printInstruction();
        playerStrategy.scanMove(gui);
        if (!playerStrategy.validate()) {
            System.out.println("You chose wrong character. Try again:");
            play(afterRound);
        }
        result = checker.checkIfEndOrExit(playerStrategy.getPlayerInput());

        checkMoves();
        checkGameWinner(afterRound);

        return result;
    }

    private void checkMoves() {
        if (result == null) {
            result = checker.compare(playerStrategy.getMove(), computerStrategy.getMove());
            statistics.addResult(result);
            gui.printRoundResult(definition.getPlayerName(),
                    playerStrategy.getPlayerMove(),
                    computerStrategy.getComputerMove(),
                    result,
                    statistics.getPlayerRoundResult(),
                    statistics.getComputerRoundResult());
        }
    }

    private void checkGameWinner(AfterRound afterRound) {
        if (statistics.checkGameResult(definition.getRoundsToWin())) {
            gui.printWinner(definition.getPlayerName(), statistics.getWins(), statistics.getLosts());
            statistics.resetRoundScore();
            gui.printAfterGameInfo(afterRound, this, statistics);
        }
    }
}
