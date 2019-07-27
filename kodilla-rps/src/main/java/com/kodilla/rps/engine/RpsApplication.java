package com.kodilla.rps.engine;

import com.kodilla.rps.gameDefinition.GameDefinition;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.statistics.Statistics;
import com.kodilla.rps.strategy.PlayerStrategy;

public class RpsApplication {

    private static GameDefinition definition;
    private static Statistics statistics;
    private static PlayerStrategy playerStrategy;

    public RpsApplication() {
        statistics = new Statistics();
        playerStrategy = new PlayerStrategy();
    }

    public static void run() {
        definition = playerStrategy.init();

        Round round = new Round(statistics, definition);

        playerStrategy.react(round.play(playerStrategy), round, statistics);
    }
}
