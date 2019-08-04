package com.kodilla.rps.statistics;

import com.kodilla.rps.model.RoundResult;

public class Statistics {

    private int playerRoundsWin;
    private int playerRoundsLost;
    private int roundNumber;

    public void updateStatistics(RoundResult result) {
        switch (result) {
            case WIN: {
                roundNumber++;
                playerRoundsWin++;
                break;
            }
            case LOSE: {
                roundNumber++;
                playerRoundsLost++;
                break;
            }
            case DRAW: {
                roundNumber++;
                break;
            }
        }
    }

    public boolean isGameOn(int roundsToWin) {
        if (playerRoundsWin == roundsToWin || playerRoundsLost == roundsToWin) {
            resetRoundNumber();
            return false;
        }
        return true;
    }

    private void resetRoundNumber() {
        roundNumber = 0;
    }

    public int getPlayerRoundsWin() {
        return playerRoundsWin;
    }

    public int getComputerRoundsLost() {
        return playerRoundsLost;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}