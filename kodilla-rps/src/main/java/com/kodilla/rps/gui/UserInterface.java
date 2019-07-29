package com.kodilla.rps.gui;

import com.kodilla.rps.gameDefinition.GameDefinition;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.round.AfterRound;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.statistics.RoundResult;
import com.kodilla.rps.statistics.Statistics;

public interface UserInterface {

    void printIntro();
    
    GameDefinition nameAndRoundsToWinQuestion();

    void printInstruction();

    void printRoundResult(String playerName,
                          Move playerMove,
                          Move computerMove,
                          RoundResult result,
                          int playerRoundResult,
                          int computerRoundResult);

    String scanPlayerMove();

    void printWinner(String name, int playerWins, int computerWins);

    void printAfterGameInfo(AfterRound afterRound, Round round, Statistics statistics);

    String exitGameInfo();

    String resetGameInfo();
}
