package com.kodilla.rps.engine;

import com.kodilla.rps.gameDefinition.GameDefinition;
import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.round.AfterRound;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.statistics.Statistics;

public class Game {

    private Statistics statistics;
    private AfterRound afterRound;
    private final UserInterface gui;

    public Game(UserInterface gui) {
        this.statistics = new Statistics();
        this.afterRound = new AfterRound();
        this.gui = gui;
    }

    public void start() {
        GameDefinition definition = init();

        Round round = new Round(statistics, definition, gui);

        afterRound.react(gui, round.play(afterRound), round, statistics);
    }

    private GameDefinition init() {
        gui.printIntro();
        return gui.nameAndRoundsToWinQuestion();
    }
}
