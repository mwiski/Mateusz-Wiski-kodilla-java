package com.kodilla.rps.gui;

import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.GameResult;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.round.AfterRound;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.statistics.Statistics;

public interface UserInterface {

    void printIntro();

    String nameQuestion();

    int roundsQuestion();

    void showInstruction();

    void showRoundResult(String playerName,
                         Move playerMove,
                         Move computerMove,
                         RoundResult result,
                         int playerRoundResult,
                         int computerRoundResult);

    String scanPlayerMove();

    void showWinner(GameDefinition definition, int playerWins, int computerWins);

    GameResult afterGameInfo(AfterRound afterRound, Round round, Statistics statistics);

    RoundResult exitGame();

    RoundResult resetGame();

    void printWrongCharacter();
}
