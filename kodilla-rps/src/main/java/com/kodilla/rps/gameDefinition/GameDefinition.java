package com.kodilla.rps.gameDefinition;

public class GameDefinition {

    private String playerName;
    private int roundsToWin;

    public GameDefinition(String playerName, int roundsToWin) {
        this.playerName = playerName;
        this.roundsToWin = roundsToWin;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getRoundsToWin() {
        return roundsToWin;
    }
}
