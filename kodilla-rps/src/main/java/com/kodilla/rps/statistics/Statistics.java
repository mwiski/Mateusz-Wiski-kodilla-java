package com.kodilla.rps.statistics;

public class Statistics {

    private int userRoundResult;
    private int computerRoundResult;
    private int userWins;
    private int computerWins;

    public int addResult(RoundResult result) {
        if (result == RoundResult.WIN) {
            return userRoundResult++;
        } else if (result == RoundResult.LOSE) {
            return computerRoundResult++;
        }
        return 0;
    }

    public void checkWins(int roundsToWin) {
        if (userRoundResult == roundsToWin) {
            addWin(userWins);
            resetRoundScore();
        } else if (computerRoundResult == roundsToWin) {
            addWin(computerWins);
            resetRoundScore();
        }
    }

    public int addWin(int wins) {
        return wins++;
    }

    private void resetRoundScore() {
        userRoundResult = 0;
        computerRoundResult = 0;
    }
}
