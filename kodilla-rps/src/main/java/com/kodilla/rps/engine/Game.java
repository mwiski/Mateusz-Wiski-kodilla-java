package com.kodilla.rps.engine;

import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.round.AfterGame;
import com.kodilla.rps.round.AfterRound;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.statistics.Statistics;

public class Game {

    private Statistics statistics;
    private AfterRound afterRound;
    private AfterGame afterGame;
    private final UserInterface gui;

    public Game(UserInterface gui) {
        this.statistics = new Statistics();
        this.afterRound = new AfterRound();
        this.afterGame = new AfterGame();
        this.gui = gui;
    }

    public void start() {
        GameDefinition definition = new GameDefinition(gui.nameQuestion(), gui.roundsQuestion());

        Round round = new Round(statistics, definition, gui);

        if (round.play()) {
            afterGame.next(gui.afterGameInfo(afterRound, round, statistics), this);
        }
    }
}
