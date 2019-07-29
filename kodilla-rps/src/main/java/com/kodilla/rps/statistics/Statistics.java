package com.kodilla.rps.statistics;

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

    public void addWins() {
        wins++;
    }

    public void addLosts(){
        losts++;
    }

    public void resetRoundScore() {
        playerRoundResult = 0;
        computerRoundResult = 0;
    }

    public boolean checkGameResult(int roundsToWin) {
        if (playerRoundResult == roundsToWin) {
            addWins();
            return true;
        } else if (computerRoundResult == roundsToWin) {
            addLosts();
            return true;
        }
        return false;
    }

    public int getPlayerRoundResult() {
        return playerRoundResult;
    }

    public int getComputerRoundResult() {
        return computerRoundResult;
    }

    public int getWins() {
        return wins;
    }

    public int getLosts() {
        return losts;
    }
}
