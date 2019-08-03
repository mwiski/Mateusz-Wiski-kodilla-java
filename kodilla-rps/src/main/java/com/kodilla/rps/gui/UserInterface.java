package com.kodilla.rps.gui;

import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.GameResult;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.statistics.Statistics;

public interface UserInterface {

    void printIntro();

    String nameQuestion();

    int roundsToWinGameQuestion();

    void showInstruction();

    void showRoundResult(GameDefinition definition,
                         Move playerMove,
                         Move computerMove,
                         RoundResult result,
                         Statistics statistics);

    void printRoundNumber(int roundNumber);

    Move getPlayerMove();

    void showWinner(GameDefinition definition, Statistics statistics);

    GameResult afterGameInfo(GameDefinition definition, Statistics statistics);

    boolean confirmExit();

    boolean confirmReset();

    boolean confirmOnceAgain();

    void printWrongCharacter();

    void thankYou(String username);
}
