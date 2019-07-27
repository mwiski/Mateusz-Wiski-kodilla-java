package com.kodilla.rps.statistics;

import com.kodilla.rps.gui.UserInterface;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.strategy.PlayerStrategy;

public class Statistics {

    private int playerRoundResult;
    private int computerRoundResult;
    private int wins;
    private int losts;

    public int addResult(RoundResult result) {
        if (result == RoundResult.WIN) {
            return playerRoundResult++;
        } else if (result == RoundResult.LOSE) {
            return computerRoundResult++;
        }
        return 0;
    }

    public int addWin(int win) {
        return win++;
    }

    public void resetRoundScore() {
        playerRoundResult = 0;
        computerRoundResult = 0;
    }

    public void checkGameResult(int roundsToWin, String playerName, PlayerStrategy playerStrategy, Round round) {
        if (playerRoundResult == roundsToWin) {
            addWin(wins);
            UserInterface.printWinner(playerName, wins, losts);
            resetRoundScore();
            UserInterface.printAfterGameInfo(playerStrategy, round, this);
        } else if (computerRoundResult == roundsToWin) {
            addWin(losts);
            UserInterface.printWinner("Computer", wins, losts);
            resetRoundScore();
            UserInterface.printAfterGameInfo(playerStrategy, round, this);
        }
    }

    public int getPlayerRoundResult() {
        return playerRoundResult;
    }

    public int getComputerRoundResult() {
        return computerRoundResult;
    }
}
