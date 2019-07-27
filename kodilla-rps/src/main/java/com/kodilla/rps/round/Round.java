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
    private Statistics statistics;
    private GameDefinition definition;
    private RoundResult result;

    public Round(Statistics statistics, GameDefinition definition) {
        this.checker = new RoundChecker();
        this.computerStrategy = new ComputerStrategy();
        this.statistics = statistics;
        this.definition = definition;
    }

    public RoundResult play(PlayerStrategy playerStrategy) {
        UserInterface.printInstruction();
        String playerMove = playerStrategy.playerMove();
        result = checker.check(playerMove);

        if (result == null) {
            result = checker.compare(playerStrategy.getMove(playerMove), computerStrategy.getMove());
            statistics.addResult(result);
            afterRoundAction(playerStrategy, this);
        }

        return result;
    }

    public void afterRoundAction(PlayerStrategy playerStrategy, Round round) {

        UserInterface.printRoundResult(definition.getPlayerName(),
                playerStrategy.getPlayerMove(),
                computerStrategy.getComputerMove(),
                result,
                statistics.getPlayerRoundResult(),
                statistics.getComputerRoundResult());

        statistics.checkGameResult(definition.getRoundsToWin(), definition.getPlayerName(), playerStrategy, round);
    }
}
